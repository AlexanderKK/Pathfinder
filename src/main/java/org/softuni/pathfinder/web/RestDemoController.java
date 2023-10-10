package org.softuni.pathfinder.web;

import org.softuni.pathfinder.model.User;
import org.softuni.pathfinder.service.RestDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestDemoController {

    private final RestDemoService restDemoService;

    @Autowired
    public RestDemoController(RestDemoService restDemoService) {
        this.restDemoService = restDemoService;
    }

//    @GetMapping("/all")
    @RequestMapping(path = "/users/all", method = RequestMethod.GET)
    public List<User> getAll() {
        return this.restDemoService.getUsers();
    }

}
