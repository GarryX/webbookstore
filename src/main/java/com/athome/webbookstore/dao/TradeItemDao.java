package com.athome.webbookstore.dao;

import java.util.Collection;
import java.util.Set;

import com.athome.webbookstore.entities.TradeItem;

public interface TradeItemDao {

	// 批量保存 TradeItem 对象
	public abstract void batchSave(Collection<TradeItem> items);

	// 根据 tradeId 获取和其关联的 TradeItem 的集合
	public abstract Set<TradeItem> getTradeItemsWithTradeId(Integer tradeId);

}
