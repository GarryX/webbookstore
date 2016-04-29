package com.athome.webbookstore.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;

import com.athome.webbookstore.dao.BookDao;
import com.athome.webbookstore.entities.Book;
import com.athome.webbookstore.webitems.CriteriaBook;
import com.athome.webbookstore.webitems.Page;
import com.athome.webbookstore.webitems.ShoppingCartItem;

public class BookDaoImpl extends BaseDao implements BookDao {

	@Override
	public Book getBook(int id) {
		return (Book) getSession().get(Book.class, id);
	}

	@Override
	public Page<Book> getPage(CriteriaBook cb) {
		Page<Book> page = new Page<>(cb.getPageNo());
		page.setTotalItemNumber(getTotalBookNumber(cb));
		cb.setPageNo(page.getPageNo());
		page.setList(getPageList(cb, 3));
		return page;
	}

	@Override
	public long getTotalBookNumber(CriteriaBook cb) {
		String sql = "SELECT COUNT(*) FROM Book b WHERE b.price >= ? AND b.price <= ?";
		return (long) getSession().createQuery(sql).setFloat(0, cb.getMinPrice()).setFloat(1, cb.getMaxPrice())
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getPageList(CriteriaBook cb, int pageSize) {
		String sql = "FROM Book b WHERE b.price >= ? AND b.price <= ?";
		return getSession().createQuery(sql).setFloat(0, cb.getMinPrice()).setFloat(1, cb.getMaxPrice())
				.setFirstResult(cb.getPageNo() - 1).setMaxResults(pageSize).list();
	}

	@Override
	public int getStoreNumber(Integer id) {
		String sql = "SELECT b.storeNumber FROM Book b WHERE b.id = ?";
		return (int) getSession().createQuery(sql).setInteger(0, id).uniqueResult();
	}

	// 客户结账时更新库存及销量
	@Override
	public void batchUpdateStoreNumberAndSalesAmount(Collection<ShoppingCartItem> items) {
		String sql = "UPDATE books b SET b.salesamount = b.salesamount + ?, "
				+ "b.storenumber = b.storenumber - ? WHERE b.id = ?";
		Query query = getSession().createSQLQuery(sql);
		for(ShoppingCartItem item : items){
			query.setInteger(0, item.getQuantity()).setInteger(1, item.getQuantity())
				 .setInteger(2, item.getBook().getId()).executeUpdate();
		}
	}

}
