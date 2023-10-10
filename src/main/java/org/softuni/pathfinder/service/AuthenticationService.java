package org.softuni.pathfinder.service;

import org.softuni.pathfinder.model.dto.UserLoginBindingModel;
import org.softuni.pathfinder.model.dto.UserRegisterBindingModel;

public interface AuthenticationService {

    void register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();

}
