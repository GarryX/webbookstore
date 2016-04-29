package com.athome.webbookstore.controllers;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.RequestAware;

import com.athome.webbookstore.dao.impl.BookDaoImpl;
import com.athome.webbookstore.dao.impl.TradeDaoImpl;
import com.athome.webbookstore.dao.impl.TradeItemDaoImpl;
import com.athome.webbookstore.entities.Trade;
import com.athome.webbookstore.entities.TradeItem;
import com.athome.webbookstore.entities.User;
import com.athome.webbookstore.services.UserService;

public class UserAction implements RequestAware {

	private UserService us;

	public void setUserService(UserService us) {
		this.us = us;
	}

	public String checkHistory() {

		return "check";
	}

	private String userName;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String checking() {
		User user = us.getUserWithTrades(userName);
		Set<Trade> trades = user.getTrades();
		request.put("user", user);
		request.put("trades", trades);
		return "checked";
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
}
