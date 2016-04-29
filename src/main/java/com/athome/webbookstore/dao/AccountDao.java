package com.athome.webbookstore.dao;

import com.athome.webbookstore.entities.Account;

public interface AccountDao {

	// ���� accountId ��ȡ��Ӧ�� Account ����
	public abstract Account get(Integer accountId);

	// ���ݴ���� accountId, amount ����ָ���˻������: �۳� amount ָ����Ǯ��
	public abstract void updateBalance(Integer accountId, float amount);

}