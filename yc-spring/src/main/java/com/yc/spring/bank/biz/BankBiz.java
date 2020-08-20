package com.yc.spring.bank.biz;


import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.spring.bank.dao.AccountDao;
import com.yc.spring.bank.dao.OprecordDao;

/**
 * 银行业务
 * 开户： 向Acount
 * @author admin
 *
 */
@Service
@Transactional(rollbackFor = {IOException.class ,SQLException.class})
public class BankBiz {
	@Autowired
	private AccountDao aDao;
	@Autowired
	private OprecordDao oDao;

	public void register (int id ,String pwd, double money) {
		aDao.insert(id, pwd, money);
		aDao.insert(id,  money);
	}
	//存取值
	@Transactional(rollbackFor = {BizException.class})
	public void save(int id, double money) throws BizException {
		//省略参数效验
		aDao.update(id, money);
//		try {
			if (money > 999) {
				throw new BizException("存取款金额不能为999！");
			}
//		} catch (BizException e) {
//			//将该编译期异常转型为运行期异常
//			throw new DataAccessResourceFailureException("异常转型",e);
//		}
		//int i =1/0;
		oDao.insert(id, money);
	}
	
	public void transfer(int id1, int id2, double money) throws BizException {
		save(id1, -money);
		save(id2, money);
	}
}
