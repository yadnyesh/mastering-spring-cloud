package io.yadnyesh.springcloud.repository;

import io.yadnyesh.springcloud.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {

}
