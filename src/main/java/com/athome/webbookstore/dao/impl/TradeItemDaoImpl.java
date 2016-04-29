package com.athome.webbookstore.dao.impl;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.athome.webbookstore.dao.TradeItemDao;
import com.athome.webbookstore.entities.TradeItem;

public class TradeItemDaoImpl extends BaseDao implements TradeItemDao {

	@Override
	public void batchSave(Collection<TradeItem> items) {
		for(TradeItem item : items){
			getSession().saveOrUpdate(item);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<TradeItem> getTradeItemsWithTradeId(Integer tradeId) {
		String hql = "FROM TradeItem ti WHERE ti.tradeId = ? ORDER BY ti.tradeId DESC";
		List<TradeItem> list = getSession().createQuery(hql).setInteger(0, tradeId).list();
		return new LinkedHashSet<>(list);
	}

}
