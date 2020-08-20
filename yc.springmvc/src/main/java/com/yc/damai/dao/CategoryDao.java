package com.yc.damai.dao;

import java.util.List;

import com.yc.damai.util.DBHelper;

public class CategoryDao {
	
	public List<?> query() {
		return new DBHelper().query("select * from dm_category");
		
	}
//select cname from dm_category where id in(1,2,3,4,5,6,7)
	
	public List<?> queryBycname() {
		return new DBHelper().query("select cname from dm_category where id in(1,2,3,4,5,6,7)");
		
	}
	
	//select cname from dm_category where pid=1
	public List<?> queryById() {
		return new DBHelper().query("select cname from dm_category where pid=1");
		
	}
	
}
