package com.Login.Login.Services;

import com.Login.Login.Models.State;
import com.Login.Login.Repositories.IState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StateService {
    @Autowired
    private IState stateRepository;

    public Optional<State> getStateById(Long id) {
        return stateRepository.findById(id);
    }
}
