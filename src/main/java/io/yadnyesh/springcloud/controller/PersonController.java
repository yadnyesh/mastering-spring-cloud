package io.yadnyesh.springcloud.controller;

import io.yadnyesh.springcloud.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	
	@PostMapping
	public Person addPerson(@RequestBody Person person) {
		person.setId((long) personList.size()+1);
		personList.add(person);
		return person;
	}
	
	public void deletePerson(@RequestParam("id") Long existingId){
		List<Person> personToBeDeleted = personList.stream().filter(id -> id.getId().equals(existingId)).collect(Collectors.toList());
		personList.removeAll(personToBeDeleted);
	}
	
}
