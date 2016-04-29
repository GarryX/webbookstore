package com.athome.webbookstore.services;

import java.util.Set;

import com.athome.webbookstore.dao.impl.BookDaoImpl;
import com.athome.webbookstore.dao.impl.TradeDaoImpl;
import com.athome.webbookstore.dao.impl.TradeItemDaoImpl;
import com.athome.webbookstore.dao.impl.UserDaoImpl;
import com.athome.webbookstore.entities.Trade;
import com.athome.webbookstore.entities.TradeItem;
import com.athome.webbookstore.entities.User;

public class UserService {
	private UserDaoImpl ud;
	private TradeDaoImpl td;
	private TradeItemDaoImpl tid;
	private BookDaoImpl bd;
	
	
	public void setUserDaoImpl(UserDaoImpl ud) {
		this.ud = ud;
	}

	public void setTradeDaoImpl(TradeDaoImpl td) {
		this.td = td;
	}

	public void setTradeItemDaoImpl(TradeItemDaoImpl tid) {
		this.tid = tid;
	}

	public void setBookDaoImpl(BookDaoImpl bd) {
		this.bd = bd;
	}

	public User getUser(String userName){
		return ud.getUser(userName);
	}
	
	public User getUserWithTrades(String userName){
		User user = ud.getUser(userName);
		if(user == null){
			return null;
		}
		int userId = user.getUserId();
		Set<Trade> trades = td.getTradesWithUserId(userId);
		if(trades != null){
			for(Trade trade : trades){
				Set<TradeItem> tis = tid.getTradeItemsWithTradeId(trade.getTradeId());
				if(tis != null){
					for(TradeItem item : tis){
						item.setBook(bd.getBook(item.getBookId()));
					}
				}
				trade.setItems(tis);
			}
		}
		user.setTrades(trades);
		return user;
		
	}
}
