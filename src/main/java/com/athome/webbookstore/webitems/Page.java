package com.athome.webbookstore.webitems;

import java.util.List;

public class Page<T> {
	//��ǰ�ڼ�ҳ
	private int pageNo;
	
	//��ǰҳ��list
	private List<T> list;
	
	//ÿҳ��ʾ��������¼
	private int pageSize = 3;
	
	//�ܼ�¼��
	private long totalItemNumber;
	
	//�������ж�pageNo���г�ʼ��
	public Page(int pageNo) {
		super();
		this.pageNo = pageNo;
	}
	
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
	
	public void setList(List<T> list) {
		this.list = list;
	}
	
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
	
	public boolean hasNextPage(){
		if(getPageNo() != getTotalPageNumber()){
			return true;
		}
		return false;
	}
	
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
