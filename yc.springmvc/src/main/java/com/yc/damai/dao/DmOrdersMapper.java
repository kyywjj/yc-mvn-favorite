package com.yc.damai.dao;

import com.yc.damai.po.DmOrders;

public interface DmOrdersMapper {

	// 新增订单
//	@Insert("insert into dm_orders values (null,#{total},now(),#{state},#{uid},#{aid})")
//	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int insert(DmOrders dos);

}
