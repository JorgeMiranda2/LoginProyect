package com.Login.Login.Services;

import com.Login.Login.Models.Person;
import com.Login.Login.Repositories.IPerson;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonService {
    private final IPerson iperson;

    public PersonService(IPerson iperson){
        this.iperson = iperson;
    }
    public List<Person> list() {
        return iperson.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return iperson.findById(id);
    }

    public Long save(Person person) {
        Person savedPerson = iperson.save(person);
        return savedPerson.getId();
    }

    public void delete(Person person) {
        iperson.delete(person);
    }
}
