package com.athome.webbookstore.dao.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.athome.webbookstore.dao.TradeDao;
import com.athome.webbookstore.entities.Trade;

public class TradeDaoImpl extends BaseDao implements TradeDao{

	@Override
	public void insert(Trade trade) {
		getSession().saveOrUpdate(trade);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Trade> getTradesWithUserId(Integer userId) {
		String hql = "From Trade t WHERE t.userId = ?";
		List<Trade> list =  getSession().createQuery(hql).setInteger(0, userId).list();
		return new LinkedHashSet<>(list);
	}

}
