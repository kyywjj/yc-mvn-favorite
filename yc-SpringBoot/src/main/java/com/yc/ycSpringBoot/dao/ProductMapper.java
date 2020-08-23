package com.yc.ycSpringBoot.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.yc.damai.bean.DmProduct;
public interface ProductMapper {
	@Select("select * from dm_product")
	List<DmProduct>selectAll();
	
	@Select("select * from dm_product where is_hot=1 limit 0,10")
	List<DmProduct>selectHot();
	
	
	@Select("select * from dm_product where is_hot=0 limit 0,20")
	List<DmProduct>selectNew();

	@Select("select * from dm_product where id=#{id}")
	DmProduct selectById(int id);
}
