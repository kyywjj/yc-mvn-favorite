package com.yc.ycSpringBoot;

import javax.annotation.Resource;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import com.yc.damai.bean.DmUser;
import com.yc.ycSpringBoot.biz.UserBiz;
import com.yc.ycSpringBoot.dao.UserDao;

@SpringBootTest
public class UserBizTest {
	@MockBean
	private UserDao udao;
	@Resource
	private UserBiz uBiz;
	
	@Test
	public void testLogin() {
		try {
			DmUser dbret = new DmUser();
			Mockito.when(udao.selectByName("武松", "123")).thenReturn(dbret);
			DmUser user=uBiz.login("武松", "123");
			Assert.isTrue(user!=null,"dao异常");
			System.out.println("测试完成");
		} catch (Exception e) {
			Assert.isTrue(e==null,"dao异常");
			e.printStackTrace();
		}
		
	}
}
