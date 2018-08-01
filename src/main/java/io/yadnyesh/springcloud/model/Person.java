package io.yadnyesh.springcloud.model;

import io.yadnyesh.springcloud.constant.Gender;

public class Person {
	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	private Gender gender;
	
	public Person() {
	}
	
	public Person(Long id, String firstName, String lastName, int age, Gender gender) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}
}
