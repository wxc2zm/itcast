package cn.itcast.test.entity;

import java.io.Serializable;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
