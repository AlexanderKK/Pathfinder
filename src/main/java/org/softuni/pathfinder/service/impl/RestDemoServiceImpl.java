package org.softuni.pathfinder.service.impl;

import org.softuni.pathfinder.model.User;
import org.softuni.pathfinder.repository.UserRepository;
import org.softuni.pathfinder.service.RestDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestDemoServiceImpl implements RestDemoService {

    private final UserRepository userRepository;

    @Autowired
    public RestDemoServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

}
