package com.athome.webbookstore.dao.impl;

import com.athome.webbookstore.dao.UserDao;
import com.athome.webbookstore.entities.User;

public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public User getUser(String userName) {
		String hql = "FROM User u WHERE u.userName = ?";
		return (User) getSession().createQuery(hql).setString(0, userName).uniqueResult();
	}

}
