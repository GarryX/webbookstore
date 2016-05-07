package com.athome.webbookstore.dao;

import java.util.Collection;
import java.util.List;

import com.athome.webbookstore.entities.Book;
import com.athome.webbookstore.webitems.CriteriaBook;
import com.athome.webbookstore.webitems.Page;
import com.athome.webbookstore.webitems.ShoppingCartItem;

public interface BookDao {
	// ���� id ��ȡָ�� Book ����
	Book getBook(int id);

	// ���ݴ���� CriteriaBook ���󷵻ض�Ӧ�� Page ����
	Page<Book> getPage(CriteriaBook cb);

	// ���ݴ���� CriteriaBook ���󷵻����Ӧ�ļ�¼��
	long getTotalBookNumber(CriteriaBook cb);

	// ���ݴ���� CriteriaBook �� pageSize ���ص�ǰҳ��Ӧ�� List
	List<Book> getPageList(CriteriaBook cb, int pageSize);

	// ����ָ�� id �� book �� storeNumber �ֶε�ֵ
	int getStoreNumber(Integer id);

	/* 
	 * ���ݴ���� ShoppingCartItem �ļ���,
	 * �������� books ���ݱ�� storenumber �� salesnumber �ֶε�ֵ
	 */ 
	void batchUpdateStoreNumberAndSalesAmount(Collection<ShoppingCartItem> items);
}
