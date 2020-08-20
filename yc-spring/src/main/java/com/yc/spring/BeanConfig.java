package com.yc.spring;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.yc.spring.bean.Person;

/**
 * 注解方式配置IOC容器
 * @author admin
 *
 */

@Configuration  //IOC容器注解配置类注解 ==>beans.xml
@ComponentScan("com.yc.spring")
public class BeanConfig {
	
	//xml中的每一个bean 对象java的一个方法 这个方法返回bean 对象
	//方法名不限定 
	
//	@Bean(name = "odao")
//	public OracleUserDao getOracleUserDao() {
//		return new OracleUserDao();
//	}
//	@Bean(name = "mdao")
//	public MySQLUserDao getMySQLUserDao() {
//		return new MySQLUserDao();
//	}
	
	@Bean(name = "hello")
	public Hello getHello() {
		return new Hello();
	}
	
	@Bean(name = "p1")
	public Person getPerson1() {
		Person ret = new Person();
		ret.setName("武松");
		ret.setAge(35);
		ret.setKilleds(new ArrayList<String>());
		ret.getKilleds().add("西门庆");
		ret.getKilleds().add("西门庆");
		ret.getKilleds().add("蒋门神");
		ret.getKilleds().add("西门庆");
		ret.getKilleds().add("西门庆");
		return ret;
	}
	
	@Bean(name = "p4")
	public Person getPerson5() {
		Person p = Person.personFactory();
		p.setName("王英");
		return p;
	}
	
	/**
	 * 原型模式
	 */
	@Bean("hello1")
	@Scope(value = "prototype") //对应的<bean scope="prototype">
	public Hello getHello1() {
		return new Hello();
		
	}
	/**
	 * 懒加载
	 */
	@Bean("hello2")
	@Lazy
	public Hello getHello2() {
		return new Hello();
		
	}
	

}
