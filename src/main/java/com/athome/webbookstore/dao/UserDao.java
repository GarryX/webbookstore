package com.athome.webbookstore.dao;

import com.athome.webbookstore.entities.User;

public interface UserDao {

	//�����û�����ȡUser����
	public abstract User getUser(String username);

}

