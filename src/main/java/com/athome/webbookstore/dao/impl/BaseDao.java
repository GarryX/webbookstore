package com.athome.webbookstore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
/*
 * BaseDao,作为一个功能类，提供getSession方法，并让其它
 * Dao实现类继承
 */
public class BaseDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
