package com.athome.webbookstore.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.athome.webbookstore.entities.Book;
import com.athome.webbookstore.services.BookService;
import com.athome.webbookstore.utils.WebUtils;
import com.athome.webbookstore.webitems.CriteriaBook;
import com.athome.webbookstore.webitems.Page;
import com.athome.webbookstore.webitems.ShoppingCart;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport implements RequestAware {
	private static final long serialVersionUID = 1L;

	private BookService bs;

	public void setBookService(BookService bs) {
		this.bs = bs;
	}
	
	public String listBooks() {
		CriteriaBook cb;
		int pageNo = 1;
		float minPrice = 0;
		float maxPrice = Float.MAX_VALUE;
		String pageNoStr = ServletActionContext.getRequest().getParameter("pageNo");
		String minPriceStr = ServletActionContext.getRequest().getParameter("minPrice");
		String maxPriceStr = ServletActionContext.getRequest().getParameter("maxPrice");
		try {
			minPrice = Float.parseFloat(minPriceStr);
		} catch (Exception e) {
		}
		try {
			maxPrice = Float.parseFloat(maxPriceStr);
		} catch (Exception e) {
		}
		try {
			pageNo = Integer.parseInt(pageNoStr);
		} catch (Exception e) {
		}

		cb = new CriteriaBook(minPrice, maxPrice, pageNo);
		Page<Book> page = bs.getPage(cb);
		request.put("page", page);
		return "books";
	}

	public String listBook() {
		String bookIdStr = ServletActionContext.getRequest().getParameter("bookId");
		int bookId = -1;
		try {
			bookId = Integer.parseInt(bookIdStr);
		} catch (Exception e) {
		}
		Book book = bs.getBook(bookId);
		request.put("book", book);
		return "book";
	}

	public String addToCart() {
		HttpServletRequest req = ServletActionContext.getRequest();
		String bookIdStr = req.getParameter("bookId");
		int bookId = -1;
		try {
			bookId = Integer.parseInt(bookIdStr);
		} catch (Exception e) {
		}

		boolean flag = false;
		if (bookId > 0) {
			ShoppingCart shoppingCart = WebUtils.getShoppingCart(req);
			flag = bs.addToCart(bookId, shoppingCart);
		}
		if (flag) {
			return listBooks();// 此处不能直接返回"books"字符串，否则客户端将不显示书目
		}

		return "error-1";
	}

	public String checkCart() {

		return "cart";
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
}
