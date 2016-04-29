package com.athome.webbookstore.dao;

import java.util.Set;

import com.athome.webbookstore.entities.Trade;

public interface TradeDao {

	// 向数据表中插入 Trade 对象
	public abstract void insert(Trade trade);

	// 根据 userId 获取和其关联的 Trade 的集合
	public abstract Set<Trade> getTradesWithUserId(Integer userId);

}