package com.yc.S3Kyyblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.S3Kyyblog.bean.Category;

public interface CategoryMapper {
	
	@Select("select * from category ")
	public List<Category>selectAll();
}
