package com.athome.webbookstore.dao;

import java.util.Collection;
import java.util.Set;

import com.athome.webbookstore.entities.TradeItem;

public interface TradeItemDao {

	// �������� TradeItem ����
	public abstract void batchSave(Collection<TradeItem> items);

	// ���� tradeId ��ȡ��������� TradeItem �ļ���
	public abstract Set<TradeItem> getTradeItemsWithTradeId(Integer tradeId);

}
