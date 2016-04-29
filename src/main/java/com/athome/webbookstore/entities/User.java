package com.athome.webbookstore.entities;

import java.util.LinkedHashSet;
import java.util.Set;

public class User {

	private Integer userId;
	private String userName;
	private int accountId;

	private Set<Trade> trades = new LinkedHashSet<Trade>();

	public void setTrades(Set<Trade> trades) {
		this.trades = trades;
	}

	public Set<Trade> getTrades() {
		return trades;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + userName + ", accountId=" + accountId + "]";
	}

	public User(Integer userId, String username, int accountId) {
		super();
		this.userId = userId;
		this.userName = username;
		this.accountId = accountId;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
}
