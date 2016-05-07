package com.athome.webbookstore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
/*
 * BaseDao,��Ϊһ�������࣬�ṩgetSession��������������
 * Daoʵ����̳�
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
