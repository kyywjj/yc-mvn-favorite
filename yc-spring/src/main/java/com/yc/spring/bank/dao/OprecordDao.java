package com.yc.spring.bank.dao;

import java.util.*;
import java.nio.channels.NonWritableChannelException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.spring.bank.bean.Oprecord;

@Repository
public class OprecordDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int insert(int id, int accountid, double opmoney, double charge, double optime) {
		return jdbcTemplate.update("insert into oprecord value(?,?,?,?,?)",id,accountid,opmoney,charge,optime);
		 
	}
	
	
	public List<Oprecord> selectById(int id){
		String sql="select * from oprecord where id = ?";
		Object[] args = {id};
		
		return jdbcTemplate.query(sql, args, new RowMapper<Oprecord>() {
			public Oprecord mapRow(ResultSet rs,int rowNum) throws SQLException {
				Oprecord op = new Oprecord();
				op.setId(rs.getInt("id"));
				op.setAccountid(rs.getInt("accountid"));
				op.setOpmoney(rs.getDouble("opmoney"));
				op.setCharge(rs.getDouble("charge"));
				op.setOptime(rs.getTimestamp("optime"));
				return op;
			}
		});
			
	}


	public int insert(int id, double money) {
		return jdbcTemplate.update("insert into oprecord value(null,?,?,null,now())",id,money);
		
	}

}
