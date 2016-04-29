package com.athome.webbookstore.dao;

import java.util.List;

public interface Dao<T> {
	//ִ��insert����,���ز����ļ�¼��ID
	long insert(String sql, Object ... args);
	
	//ִ��update����,����insert(��û�з���ֵ), update, delete��
	void update(String sql, Object ... args);
	
	//ִ�е�����¼��ѯ���������������¼��Ӧ�����һ������
	T query(String sql, Object ... args);
	
	List<T> queryForList(String sql, Object ... args);
	
	/**
	 * ִ��һ�����Ի�ֵ�Ĳ�ѯ����, �����ѯĳһ����¼��һ���ֶ�, ���ѯĳ��ͳ����Ϣ, ����Ҫ��ѯ��ֵ
	 * @param sql: ��ִ�е� SQL ���
	 * @param args: ���ռλ���Ŀɱ����
	 * @return: ִ��һ�����Ի�ֵ�Ĳ�ѯ����, �����ѯĳһ����¼��һ���ֶ�, ���ѯĳ��ͳ����Ϣ, ����Ҫ��ѯ��ֵ
	 */
	<V> V getSingleVal(String sql, Object ... args);
	
	/**
	 * ִ���������²���
	 * @param sql: ��ִ�е� SQL ���
	 * @param args: ���ռλ���Ŀɱ����
	 */
	void batch(String sql, Object[]... params);
}
