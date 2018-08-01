package io.yadnyesh.springcloud.controller;

import io.yadnyesh.springcloud.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
	private List<Person> personList = new ArrayList<>();
	
	@GetMapping
	public List<Person> getAllPersons(){
		return personList;
	}
	
	@GetMapping("/{id")
	public Person getPersonById(@RequestParam("id") Long id) {
		return personList.stream().filter(person -> person.getId().equals(id)).findFirst().get();
	}
	
}
