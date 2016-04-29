package com.athome.webbookstore.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.athome.webbookstore.webitems.ShoppingCart;

public class WebUtils {
	
	//��ȡ���ﳵ���󣺴�session�л�ȡ����session��û�иö��󣬸մ���һ���µĹ��ﳵ����
	//�����뵽session�У����У���ֱ�ӷ��ظö���
	public static ShoppingCart getShoppingCart(HttpServletRequest request){
		HttpSession session = request.getSession();
		ShoppingCart sc = (ShoppingCart) session.getAttribute("shoppingCart");
		if(sc == null){
			sc = new ShoppingCart();
			session.setAttribute("shoppingCart", sc);
		}
		return sc;
	}
}
