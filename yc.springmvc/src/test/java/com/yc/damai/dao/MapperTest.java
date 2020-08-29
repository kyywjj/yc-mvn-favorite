package com.yc.damai.dao;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration("/bean.xml")
public class MapperTest {
	@Resource
	DmProductMapper mapper;
	
	@Test
	public void test12() {
		mapper.selectById(2);
		
	}
	
}
