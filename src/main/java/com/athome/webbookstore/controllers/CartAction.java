package com.athome.webbookstore.controllers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.athome.webbookstore.entities.Account;
import com.athome.webbookstore.entities.User;
import com.athome.webbookstore.services.AccountService;
import com.athome.webbookstore.services.BookService;
import com.athome.webbookstore.services.CartService;
import com.athome.webbookstore.services.UserService;
import com.athome.webbookstore.utils.WebUtils;
import com.athome.webbookstore.webitems.ShoppingCart;
import com.athome.webbookstore.webitems.ShoppingCartItem;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements RequestAware {

	private static final long serialVersionUID = 1L;
	private CartService cs;
	private UserService us;
	private AccountService as;
	private BookService bs;

	public void setCartService(CartService cs) {
		this.cs = cs;
	}

	public void setUserService(UserService us) {
		this.us = us;
	}

	public void setAccountService(AccountService as) {
		this.as = as;
	}

	public void setBookService(BookService bs) {
		this.bs = bs;
	}

	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public String deleteItem() {
		HttpServletRequest req = ServletActionContext.getRequest();
		ShoppingCart sc = WebUtils.getShoppingCart(req);
		String bookIdStr = req.getParameter("bookId");
		int bookId = -1;
		if (sc != null) {
			try {
				bookId = Integer.parseInt(bookIdStr);
				sc.removeItem(bookId);
			} catch (NumberFormatException e) {}
		}
		return "cart";
	}

	public String clearCart() {
		HttpServletRequest req = ServletActionContext.getRequest();
		ShoppingCart sc = WebUtils.getShoppingCart(req);
		if(sc != null){
			cs.removeFromCart(sc);
		}
		return "cart";
	}

	public String updateItemQuantity() {
		HttpServletRequest req = ServletActionContext.getRequest();
		String idStr = req.getParameter("id");
		String quantityStr = req.getParameter("quantity");
		int id = -1;
		int quantity = -1;
		try {
			id = Integer.parseInt(idStr);
			quantity = Integer.parseInt(quantityStr);
		} catch (NumberFormatException e) {}
		ShoppingCart sc = WebUtils.getShoppingCart(req);
		if (sc != null && id > 0 && quantity > 0) {
			cs.updateItemQuantity(sc, id, quantity);
		}
		float totalBill = sc.getTotalCost();
		String bill = totalBill + "";
		try {
			inputStream = new ByteArrayInputStream(bill.getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Ajax";
	}

	public String goCashing() {

		return "cash";
	}

	public String cashing() {
		HttpServletRequest req = ServletActionContext.getRequest();
		String userName = req.getParameter("userName");
		String accountId = req.getParameter("accountId");
		StringBuffer errors = vadidateFormField(userName, accountId);
		if (errors.toString().equals("")) {
			errors = vadidateUserInfo(userName, accountId);
			if (errors.toString().equals("")) {
				errors = vadidateStoreNumber(req);
				if (errors.toString().equals("")) {
					errors = vadidateBalance(req, accountId);
				}
			}
		}
		if(!errors.toString().equals("")){
			request.put("errors", errors);
			return "cash";
		}
		ShoppingCart sc = WebUtils.getShoppingCart(req);
		if (sc != null) {
			cs.cashing(sc, userName, accountId);
		}
		return "cahsed";
	}

	// 验证余额是否充足
	protected StringBuffer vadidateBalance(HttpServletRequest request, String accountId) {
		StringBuffer errors = new StringBuffer("");
		ShoppingCart sc = WebUtils.getShoppingCart(request);
		Account account = as.getAccount(Integer.parseInt(accountId));
		if (sc != null && account != null) {
			if (account.getBalance() < sc.getTotalCost()) {
				errors.append("余额不足!");
			}
		}
		return errors;
	}

	// 验证库存是否充足
	protected StringBuffer vadidateStoreNumber(HttpServletRequest request) {
		StringBuffer errors = new StringBuffer("");
		ShoppingCart sc = WebUtils.getShoppingCart(request);
		if (sc != null) {
			for (ShoppingCartItem item : sc.getShoppingCartItems()) {
				int quantity = item.getQuantity();
				int number = bs.getBook(item.getBook().getId()).getStoreNumber();
				if (quantity > number) {
					errors.append(item.getBook().getTitle() + "库存不足!");
				}
			}
		}
		return errors;
	}

	// 验证账户名与账号是否匹配
	protected StringBuffer vadidateUserInfo(String username, String accountid) {
		StringBuffer errors = new StringBuffer("");
		User user = us.getUser(username);
		boolean flag = false;
		if (user != null) {
			int account = user.getAccountId();
			if (accountid.trim().equals("" + account)) {
				flag = true;
			}
		}
		if (flag == false) {
			errors.append("账户名与账号不匹配！");
		}
		return errors;
	}

	// 验证表单域的值是否符合规则，如用户名不能为空，账号不能为空等
	protected StringBuffer vadidateFormField(String username, String accountid) {
		StringBuffer errors = new StringBuffer("");
		if (username == null || username.trim().equals("")) {
			errors.append("用户名不能为空  ");
		}
		if (accountid == null || accountid.trim().equals("")) {
			errors.append(" 账号不能为空");
		}
		return errors;
	}

	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
}
