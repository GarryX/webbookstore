package com.athome.webbookstore.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.athome.webbookstore.webitems.ShoppingCart;

public class WebUtils {
	
	//获取购物车对象：从session中获取，若session中没有该对象，刚创建一个新的购物车对象，
	//并放入到session中，若有，则直接返回该对象
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
