package io.yadnyesh.springcloud.repository;

import io.yadnyesh.springcloud.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {
	public List<Person> findByLastName(String lastName);
	public List<Person> findByAgeGreaterThan(int age);
}
