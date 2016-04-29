package com.athome.webbookstore.webitems;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.athome.webbookstore.entities.Book;

public class ShoppingCart {
	private Map<Integer, ShoppingCartItem> books = new HashMap<>();

	// ���ﳵ�����һ����
	public void addBook(Book book) {
		// ��鹺�ﳵ��û�и��飬���У�ʹ������+1
		ShoppingCartItem sci = books.get(book.getId());
		if (sci == null) {
			sci = new ShoppingCartItem(book);
			books.put(book.getId(), sci);
		} else {
			sci.increase();
		}
		// ��û�У��򴴽���Ӧ��ShoppingCartItem���󣬲�����ӷŵ�books��

	}

	// �жϹ��ﳵ���Ƿ���id��Ӧ����
	public boolean hasBook(int id) {
		return books.containsKey(id);
	}

	public Map<Integer, ShoppingCartItem> getBooks() {
		return books;
	}

	// ���ع��ﳵ�����������
	public int getTotalBookNumber() {
		int total = 0;
		for (ShoppingCartItem sci : books.values()) {
			total += sci.getQuantity();
		}
		return total;
	}

	// ��ȡ���ﳵ������ShoppingCartItem��ɵļ���
	public Collection<ShoppingCartItem> getShoppingCartItems() {
		return books.values();
	}

	// ��ȡ���ﳵ��������Ʒ���ܼ�ֵ
	public float getTotalCost() {
		float total = 0;
		for (ShoppingCartItem sci : books.values()) {
			total += sci.getItemCost();
		}
		return total;
	}

	// �жϹ��ﳵ���Ƿ�Ϊ��
	public boolean isEmpty() {
		return books.isEmpty();
	}

	// ��չ��ﳵ
	public void clear() {
		books.clear();
	}

	// �Ƴ�ָ���Ĺ�����
	public void removeItem(Integer id) {
		books.remove(id);
	}

	// �޸�ָ�������������
	public void updateItemQuantity(Integer id, int quantity) {
		ShoppingCartItem sci = books.get(id);
		if (sci != null) {
			sci.setQuantity(quantity);
		}
	}
}
