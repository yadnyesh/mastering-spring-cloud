package io.yadnyesh.springcloud.controller;

import io.yadnyesh.springcloud.model.Person;
import io.yadnyesh.springcloud.repository.PersonRepository;
import io.yadnyesh.springcloud.service.PersonCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PersonCounterService personCounterService;
	
	private List<Person> personList = new ArrayList<>();
	
	@GetMapping
	public List<Person> getAllPersons(){
		return personRepository.findAll();
	}
	
	@GetMapping("/{id")
	public Person getPersonById(@RequestParam("id") String id) {
		return personRepository.findOne(id);
	}
	
	@GetMapping("/{lastName}")
	public List<Person> getPersonByLastName(@RequestParam("lastName") String lastName) {
		return personRepository.findByLastName(lastName);
	}
	
	@GetMapping("/{age}")
	public List<Person> getPersonByAge(@RequestParam("age") int age) {
		return personRepository.findByAgeGreaterThan(age);
	}
	
	@PostMapping
	public Person addPerson(@RequestBody Person person) {
		personRepository.save(person);
		personCounterService.countNewPersons();
		return person;
	}
	
	@DeleteMapping
	public void deletePerson(@RequestParam("id") String existingId){
		personRepository.delete(existingId);
		personCounterService.countDeletedPersons();
	}
	
	@PutMapping
	public void updatePerson(@RequestBody Person personToUpdate) {
		personRepository.save(personToUpdate);
	}
}
