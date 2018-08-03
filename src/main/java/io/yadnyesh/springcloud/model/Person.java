package io.yadnyesh.springcloud.model;

import io.yadnyesh.springcloud.constant.Gender;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
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
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
