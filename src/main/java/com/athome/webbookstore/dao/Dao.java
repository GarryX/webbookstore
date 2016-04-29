package com.athome.webbookstore.dao;

import java.util.List;

public interface Dao<T> {
	//执行insert操作,返回插入后的记录的ID
	long insert(String sql, Object ... args);
	
	//执行update操作,包括insert(但没有返回值), update, delete。
	void update(String sql, Object ... args);
	
	//执行单条记录查询操作，并返回与记录对应的类的一个对象
	T query(String sql, Object ... args);
	
	List<T> queryForList(String sql, Object ... args);
	
	/**
	 * 执行一个属性或值的查询操作, 例如查询某一条记录的一个字段, 或查询某个统计信息, 返回要查询的值
	 * @param sql: 待执行的 SQL 语句
	 * @param args: 填充占位符的可变参数
	 * @return: 执行一个属性或值的查询操作, 例如查询某一条记录的一个字段, 或查询某个统计信息, 返回要查询的值
	 */
	<V> V getSingleVal(String sql, Object ... args);
	
	/**
	 * 执行批量更新操作
	 * @param sql: 待执行的 SQL 语句
	 * @param args: 填充占位符的可变参数
	 */
	void batch(String sql, Object[]... params);
}
