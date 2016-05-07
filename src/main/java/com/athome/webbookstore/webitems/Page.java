package com.athome.webbookstore.webitems;

import java.util.List;

public class Page<T> {
	//当前第几页
	private int pageNo;
	
	//当前页的list
	private List<T> list;
	
	//每页显示多少条记录
	private int pageSize = 3;
	
	//总记录数
	private long totalItemNumber;
	
	//构造器中对pageNo进行初始化
	public Page(int pageNo) {
		super();
		this.pageNo = pageNo;
	}
	
	//获取pageNo的同时将其限定在正确的取值范围内
	public int getPageNo() {
		if(pageNo < 1){
			pageNo = 1;
		}else if(pageNo > getTotalPageNumber()){
			pageNo = getTotalPageNumber();
		}
		return pageNo;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public List<T> getList() {
		return list;
	}
	
	//将从数据库中查询到的对象集合赋给list成员变量
	public void setList(List<T> list) {
		this.list = list;
	}
	
	//根据数据库中查询到的记录数确定总页面数
	public int getTotalPageNumber(){
		int totalPageNubmer = (int)totalItemNumber/pageSize;
		if((totalItemNumber % pageSize) != 0){
			totalPageNubmer++;
		}
		return totalPageNubmer;
	}
	
	public void setTotalItemNumber(long totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}
	
	//判断是否有下一页
	public boolean hasNextPage(){
		if(getPageNo() != getTotalPageNumber()){
			return true;
		}
		return false;
	}
	
	//判断是否有前一页
	public boolean hasPrevPage(){
		if(getPageNo() != 1){
			return true;
		}
		return false;
	}
	
	public int getPrevPage(){
		if(hasPrevPage()){
			return getPageNo() - 1;
		}
		return getPageNo();
	}
	
	public int getNextPage(){
		if(hasNextPage()){
			return getPageNo() + 1;
		}
		return getPageNo();
	}
}
