package com.yc.S3Kyyblog.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;


public class Utils {
	public static Map<String , String> asMap(Errors errors){
		if (errors.hasErrors()) {
			Map<String,String>ret=new HashMap<String,String>();
			for (FieldError fe:errors.getFieldErrors()) {
				ret.put(fe.getField(), fe.getDefaultMessage());
			}
			return ret;
		}else {
			return null;
		}
	}

}
