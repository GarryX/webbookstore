package com.athome.webbookstore.services;

import com.athome.webbookstore.dao.impl.AccountDaoImpl;
import com.athome.webbookstore.entities.Account;

public class AccountService {
	
	private AccountDaoImpl ad;
	public void setAccountDaoImpl(AccountDaoImpl ad) {
		this.ad = ad;
	}
	
	public Account getAccount(Integer accountid){
		return ad.get(accountid);
	}
}
