package org.softuni.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.pathfinder.model.User;
import org.softuni.pathfinder.model.dto.UserLoginBindingModel;
import org.softuni.pathfinder.model.dto.UserRegisterBindingModel;
import org.softuni.pathfinder.repository.UserRepository;
import org.softuni.pathfinder.service.AuthenticationService;
import org.softuni.pathfinder.service.session.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository,
                                     ModelMapper modelMapper,
                                     PasswordEncoder passwordEncoder,
                                     LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {
        User user = modelMapper.map(userRegisterBindingModel, User.class);

        String encodedPassword = passwordEncoder.encode(userRegisterBindingModel.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {
        String username = userLoginBindingModel.getUsername();

        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new IllegalArgumentException(String.format("User with username: %s is not present", username));
        }

        boolean isPasswordMatched =
                passwordEncoder.matches(userLoginBindingModel.getPassword(), user.getPassword());
        if(!isPasswordMatched) {
            throw new IllegalArgumentException("User entered incorrect password");
        }

        loggedUser.setUsername(user.getUsername());
        loggedUser.setEmail(user.getEmail());
        loggedUser.setFullName(user.getFullName());
        loggedUser.setLogged(Boolean.TRUE);

        return true;
    }

    @Override
    public void logout() {
        loggedUser.reset();
    }

}
