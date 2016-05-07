package com.athome.webbookstore.webitems;

import com.athome.webbookstore.entities.Book;

//��װ�˹��ﳵ�е���Ʒ��������Ʒ�����ü����ﳵ�и���Ʒ������
public class ShoppingCartItem {
	private Book book;
	private int quantity;

	public ShoppingCartItem() {
		super();
	}
	
	//�½�������Ŀʱ����ѡBook��������+1
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

	// ���ظ���Ʒ�ڹ��ﳵ���˵����
	public float getItemCost() {
		return book.getPrice() * quantity;
	}

	// ʹ��Ʒ������1
	public void increase() {
		quantity++;
	}
}
