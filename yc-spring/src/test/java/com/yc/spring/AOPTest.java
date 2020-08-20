package com.yc.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.spring.dao.UserDao;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AOPConfig.class)
public class AOPTest {
	@Autowired
	@Qualifier("mdao")
	private  UserDao mdao;
	
	@Autowired
	@Qualifier("odao")
	private UserDao odao;
	
	@Autowired
	private Hello hello;

	@Test
	public void test1() {
		System.out.println("============1=====================");
		odao.selectUserId("");
		System.out.println("============2=====================");
		mdao.selectUserId("");
		System.out.println("============3=====================");
	}
	
	@Test
	public void test2() {
		System.out.println(mdao);
		System.out.println(odao);
		System.out.println(hello);
		
	}
}
