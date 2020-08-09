package com.yc.spring.bean;

import java.util.List;

public class Person {
	private String name;
	private String id;
	private int age;
	private String alias;//绰号
	
	private Person friend;
	
	/**
	 * 工厂方法
	 */
	public static Person personFactory() {
		Person p = new Person();
		p.setAge(40);
		return p;
		
	}
	
	/**
	 * 实例工程方法
	 */
	public  Person personFactory1() {
		Person p = new Person();
		p.setAge(20);
		return p;
		
	}
	
	private List<String> killeds;
	
	public Person() {
		
	}
	
	
	public Person getFriend() {
		return friend;
	}

	public void setFriend(Person friend) {
		this.friend = friend;
	}

	public Person(String name,int age, String alias) {
		super();
		System.out.println("===========2================");
		this.name = name;
		this.age = age;
		this.alias = alias;
	}
	
	public Person(int age,String name, String alias) {
		super();
		System.out.println("===========1================");
		this.name = name;
		this.age = age;
		this.alias = alias;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public List<String> getKilleds() {
		return killeds;
	}
	public void setKilleds(List<String> killeds) {
		this.killeds = killeds;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	

}
