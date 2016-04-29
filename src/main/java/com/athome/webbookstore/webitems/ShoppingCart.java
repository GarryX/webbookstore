package com.athome.webbookstore.webitems;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.athome.webbookstore.entities.Book;

public class ShoppingCart {
	private Map<Integer, ShoppingCartItem> books = new HashMap<>();

	// 向购物车中添加一本书
	public void addBook(Book book) {
		// 检查购物车有没有该书，若有，使其数量+1
		ShoppingCartItem sci = books.get(book.getId());
		if (sci == null) {
			sci = new ShoppingCartItem(book);
			books.put(book.getId(), sci);
		} else {
			sci.increase();
		}
		// 若没有，则创建对应的ShoppingCartItem对象，并将其加放到books中

	}

	// 判断购物车中是否有id对应的书
	public boolean hasBook(int id) {
		return books.containsKey(id);
	}

	public Map<Integer, ShoppingCartItem> getBooks() {
		return books;
	}

	// 返回购物车中书的总数量
	public int getTotalBookNumber() {
		int total = 0;
		for (ShoppingCartItem sci : books.values()) {
			total += sci.getQuantity();
		}
		return total;
	}

	// 获取购物车中所有ShoppingCartItem组成的集合
	public Collection<ShoppingCartItem> getShoppingCartItems() {
		return books.values();
	}

	// 获取购物车中所有商品的总价值
	public float getTotalCost() {
		float total = 0;
		for (ShoppingCartItem sci : books.values()) {
			total += sci.getItemCost();
		}
		return total;
	}

	// 判断购物车中是否为空
	public boolean isEmpty() {
		return books.isEmpty();
	}

	// 清空购物车
	public void clear() {
		books.clear();
	}

	// 移除指定的购物项
	public void removeItem(Integer id) {
		books.remove(id);
	}

	// 修改指定购物项的数量
	public void updateItemQuantity(Integer id, int quantity) {
		ShoppingCartItem sci = books.get(id);
		if (sci != null) {
			sci.setQuantity(quantity);
		}
	}
}
