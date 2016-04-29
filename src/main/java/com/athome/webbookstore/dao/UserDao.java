package com.athome.webbookstore.dao;

import com.athome.webbookstore.entities.User;

public interface UserDao {

	//根据用户名获取User对象
	public abstract User getUser(String username);

}

