package com.yc.ycSpringBoot;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.yc.ycSpringBoot.biz.MailService;
import com.yc.ycSpringBoot.dao.ProductMapper;

@SpringBootTest
class YcSpringBootApplicationTests {
	@Resource
	ProductMapper pm;
	
	@Resource
	MailService ms;
	
	@Test
	void contextLoads() {
		Assert.isTrue(pm.selectAll().size()>0,"没有数据");
	}
	
	@Test
	void testMail() {
		ms.sendSimpleMail("2048809939@qq.com", "密码重置设置", "您重置密码的验证码是：123456");
	}

}
