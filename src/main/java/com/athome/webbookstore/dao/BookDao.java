package com.athome.webbookstore.dao;

import java.util.Collection;
import java.util.List;

import com.athome.webbookstore.entities.Book;
import com.athome.webbookstore.webitems.CriteriaBook;
import com.athome.webbookstore.webitems.Page;
import com.athome.webbookstore.webitems.ShoppingCartItem;

public interface BookDao {
	// 根据 id 获取指定 Book 对象
	Book getBook(int id);

	// 根据传入的 CriteriaBook 对象返回对应的 Page 对象
	Page<Book> getPage(CriteriaBook cb);

	// 根据传入的 CriteriaBook 对象返回其对应的记录数
	long getTotalBookNumber(CriteriaBook cb);

	// 根据传入的 CriteriaBook 和 pageSize 返回当前页对应的 List
	List<Book> getPageList(CriteriaBook cb, int pageSize);

	// 返回指定 id 的 book 的 storeNumber 字段的值
	int getStoreNumber(Integer id);

	/* 
	 * 根据传入的 ShoppingCartItem 的集合,
	 * 批量更新 books 数据表的 storenumber 和 salesnumber 字段的值
	 */ 
	void batchUpdateStoreNumberAndSalesAmount(Collection<ShoppingCartItem> items);
}
