package org.softuni.pathfinder.service;

import org.softuni.pathfinder.model.dto.AddRouteBindingModel;
import org.springframework.stereotype.Repository;

public interface RouteService {

    void add(AddRouteBindingModel addRouteBindingModel);

}
