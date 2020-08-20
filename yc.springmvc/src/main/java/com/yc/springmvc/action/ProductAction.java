package com.yc.springmvc.action;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.dao.DmProductMapper;
import com.yc.damai.po.DmProduct;


@RestController("pAction")
public class ProductAction {
	@Resource
	private DmProductMapper pm;
	
	/**
	 * Model ==> 数据类型 ==> Map 集合可以替代Model
	 */
	@GetMapping(path="product.do",params = "op=query")
	public Map<String, Object> query(DmProduct dp){
		Map<String, Object>m= new HashMap<String, Object>();
		m.put("list", pm.selectForHot());
		return m;
	}
	
}
