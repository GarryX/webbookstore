package com.athome.webbookstore.dao;

import java.util.Set;

import com.athome.webbookstore.entities.Trade;

public interface TradeDao {

	// �����ݱ��в��� Trade ����
	public abstract void insert(Trade trade);

	// ���� userId ��ȡ��������� Trade �ļ���
	public abstract Set<Trade> getTradesWithUserId(Integer userId);

}