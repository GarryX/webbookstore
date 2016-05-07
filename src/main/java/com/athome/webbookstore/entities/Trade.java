package com.athome.webbookstore.entities;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class Trade {

	private Integer tradeId;

	private Date tradeTime;

	// Trade 关联的多个 TradeItem
	private Set<TradeItem> items = new LinkedHashSet<TradeItem>();
	
	// 和 Trade 关联的 User 的 userId
	private Integer userId;

	public void setItems(Set<TradeItem> items) {
		this.items = items;
	}

	public Set<TradeItem> getItems() {
		return items;
	}


	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", tradeTime=" + tradeTime + ", userId=" + userId + "]";
	}
}
