package org.softuni.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.pathfinder.model.Category;
import org.softuni.pathfinder.model.Route;
import org.softuni.pathfinder.model.User;
import org.softuni.pathfinder.model.dto.AddRouteBindingModel;
import org.softuni.pathfinder.repository.CategoryRepository;
import org.softuni.pathfinder.repository.RouteRepository;
import org.softuni.pathfinder.service.RouteService;
import org.softuni.pathfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper mapper;
    private final CategoryRepository categoryRepository;
    private final UserService userService;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository,
                            ModelMapper mapper,
                            CategoryRepository categoryRepository,
                            UserService userService) {
        this.routeRepository = routeRepository;
        this.mapper = mapper;
        this.categoryRepository = categoryRepository;
        this.userService = userService;
    }

    @Override
    public void add(AddRouteBindingModel addRouteBindingModel) {
        Route route = mapper.map(addRouteBindingModel, Route.class);

        route.getCategories().clear();

        Set<Category> categories = this.categoryRepository.findByNameIn(addRouteBindingModel.getCategories());

        route.setCategories(categories);

        User user = this.userService.getLoggedUser();

        route.setAuthor(user);

        routeRepository.save(route);
    }

}
