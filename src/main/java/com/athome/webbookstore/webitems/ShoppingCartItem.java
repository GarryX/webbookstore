package com.athome.webbookstore.webitems;

import com.athome.webbookstore.entities.Book;

//封装了购物车中的商品，包含商品的引用及购物车中该商品的数量
public class ShoppingCartItem {
	private Book book;
	private int quantity;

	public ShoppingCartItem() {
		super();
	}
	
	//新建购物项目时，所选Book对象数量+1
	public ShoppingCartItem(Book book) {
		super();
		this.book = book;
		this.quantity = 1;
	}

	public Book getBook() {
		return book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// 返回该商品在购物车中账单金额
	public float getItemCost() {
		return book.getPrice() * quantity;
	}

	// 使商品数量加1
	public void increase() {
		quantity++;
	}
}
