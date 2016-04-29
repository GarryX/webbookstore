package com.athome.webbookstore.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.athome.webbookstore.dao.impl.AccountDaoImpl;
import com.athome.webbookstore.dao.impl.BookDaoImpl;
import com.athome.webbookstore.dao.impl.TradeDaoImpl;
import com.athome.webbookstore.dao.impl.TradeItemDaoImpl;
import com.athome.webbookstore.dao.impl.UserDaoImpl;
import com.athome.webbookstore.entities.Trade;
import com.athome.webbookstore.entities.TradeItem;
import com.athome.webbookstore.webitems.ShoppingCart;
import com.athome.webbookstore.webitems.ShoppingCartItem;

public class CartService {
	private AccountDaoImpl ad;
	private TradeDaoImpl td;
	private UserDaoImpl ud;
	private BookDaoImpl bd;
	private TradeItemDaoImpl tid;

	public void setTradeItemDaoImpl(TradeItemDaoImpl tid) {
		this.tid = tid;
	}

	public void setBookDaoImpl(BookDaoImpl bd) {
		this.bd = bd;
	}

	public void setUserDaoImpl(UserDaoImpl ud) {
		this.ud = ud;
	}

	public void setTradeDaoImpl(TradeDaoImpl td) {
		this.td = td;
	}

	public void setAccountDaoImpl(AccountDaoImpl ad) {
		this.ad = ad;
	}

	public void removeFromCart(ShoppingCart sc) {
		sc.clear();
	}

	public void updateItemQuantity(ShoppingCart sc, int id, int quantity) {
		sc.updateItemQuantity(id, quantity);
	}

	public void cashing(ShoppingCart sc, String userName, String accountId){
		// 更新books数据表相关的salesamount 和 storenumber.
		bd.batchUpdateStoreNumberAndSalesAmount(sc.getShoppingCartItems());
		
		//测试事务回滚，设置异常
		// int i = 10/0;
		// System.out.println(i);
		
		// 更新accounts数据表的balance
		ad.updateBalance(Integer.parseInt(accountId), sc.getTotalCost());

		// 向trades数据表中插入一条记录
		Trade trade = new Trade();
		Date tradeTime = new Date(System.currentTimeMillis());
		Integer userId = ud.getUser(userName).getUserId();
		trade.setTradeTime(tradeTime);
		trade.setUserId(userId);
		td.insert(trade);
		System.out.println("~~~~~~~~~~~~~~" + td.getSession().createQuery("FROM Trade").list());

		// 向tradeitems数据表中插入N条记录
		Collection<TradeItem> c = new ArrayList<>();
		for (ShoppingCartItem sci : sc.getShoppingCartItems()) {
			TradeItem ti = new TradeItem();
			ti.setBookId(sci.getBook().getId());
			ti.setQuantity(sci.getQuantity());
			ti.setTradeId(trade.getTradeId());
			c.add(ti);
		}
		System.out.println("~~~~~~~~~~~~~~~~" + tid);
		System.out.println("~~~~~~~~~~~~~~~~" + c);
		tid.batchSave(c);

		// 清空购物车
		sc.clear();
	}
}
