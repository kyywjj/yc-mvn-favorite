package com.yc.damai.dao;

import java.util.List;


import com.yc.damai.po.DmCategory;

public interface DmCategoryMapper {
	
	
	List<DmCategory> selectAll();
	List<DmCategory> selectId();
	List<DmCategory> selectPid();
	List<DmCategory> selectChildren(int id);
	
	int insert(DmCategory dc);
	
	int update(DmCategory dc);
	int delete(int id);

}
