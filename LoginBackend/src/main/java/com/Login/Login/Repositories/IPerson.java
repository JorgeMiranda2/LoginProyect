package com.Login.Login.Repositories;

import com.Login.Login.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPerson extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(String email);
}
