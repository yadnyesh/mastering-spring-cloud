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
	
	@PostMapping
	public Person addPerson(@RequestBody Person person) {
		personRepository.save(person);
		personCounterService.countNewPersons();
		return person;
	}
	
	@DeleteMapping
	public void deletePerson(@RequestParam("id") Long existingId){
		List<Person> personToBeDeleted = personList.stream().filter(person -> person.getId().equals(existingId)).collect(Collectors.toList());
		personList.removeAll(personToBeDeleted);
		personCounterService.countDeletedPersons();
	}
	
	@PutMapping
	public void updatePerson(@RequestBody Person personToUpdate) {
		Person existingPerson = personList.stream().filter(person -> person.getId().equals(personToUpdate.getId())).findFirst().get();
		personList.set(personList.indexOf(existingPerson), personToUpdate);
	}
}
