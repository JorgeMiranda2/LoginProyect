package com.Login.Login.Repositories;

import com.Login.Login.Models.State;
import com.Login.Login.Models.StateType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IState extends JpaRepository<State, Long> {
    Optional<State> findByName(String name);
    Optional<State> findByNameAndStateType(String name, StateType stateType);
}
