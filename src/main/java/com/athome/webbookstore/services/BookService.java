package com.athome.webbookstore.services;

import com.athome.webbookstore.dao.impl.BookDaoImpl;
import com.athome.webbookstore.entities.Book;
import com.athome.webbookstore.webitems.CriteriaBook;
import com.athome.webbookstore.webitems.Page;
import com.athome.webbookstore.webitems.ShoppingCart;

public class BookService {

	private BookDaoImpl bd;
	public void setBookDaoImpl(BookDaoImpl bd) {
		this.bd = bd;
	}
	public Book getBook(int id) {
		return bd.getBook(id);
	}

	public Page<Book> getPage(CriteriaBook cb) {
		return bd.getPage(cb);
	}

	public boolean addToCart(int id, ShoppingCart sc) {
		Book book = bd.getBook(id);
		if (book != null) {
			sc.addBook(book);
			return true;
		}
		return false;
	}

}
