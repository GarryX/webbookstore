package com.athome.webbookstore.dao.impl;

import com.athome.webbookstore.dao.AccountDao;
import com.athome.webbookstore.entities.Account;

public class AccountDaoImpl extends BaseDao implements AccountDao {

	@Override
	public Account get(Integer accountId) {
		String sql = "From Account a WHERE a.accountId = ?";
		return (Account) getSession().createQuery(sql).setInteger(0, accountId).uniqueResult();
	}

	@Override
	public void updateBalance(Integer accountId, float amount) {
		String sql = "UPDATE Account a SET a.balance = a.balance - ? WHERE a.accountId = ?";
		getSession().createQuery(sql).setFloat(0, amount).setInteger(1, accountId).executeUpdate();
	}

}
