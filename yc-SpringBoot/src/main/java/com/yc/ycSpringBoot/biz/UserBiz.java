package com.yc.ycSpringBoot.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.damai.bean.DmUser;
import com.yc.ycSpringBoot.dao.UserDao;

@Service
public class UserBiz {
	@Resource
	private UserDao uDao;
	
	public DmUser login(String name,String pwd) throws BizException  {
		DmUser user = uDao.selectByName(name, pwd);
		if (user==null) {
			throw new BizException("用户名或密码错误！"); 
		}
		return user;
		
		
	}

}
