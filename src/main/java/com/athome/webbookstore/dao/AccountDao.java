package com.athome.webbookstore.dao;

import com.athome.webbookstore.entities.Account;

public interface AccountDao {

	// 根据 accountId 获取对应的 Account 对象
	public abstract Account get(Integer accountId);

	// 根据传入的 accountId, amount 更新指定账户的余额: 扣除 amount 指定的钱数
	public abstract void updateBalance(Integer accountId, float amount);

}