package org.softuni.pathfinder.web;

import org.softuni.pathfinder.model.dto.AddRouteBindingModel;
import org.softuni.pathfinder.model.enums.CategoryName;
import org.softuni.pathfinder.model.enums.Level;
import org.softuni.pathfinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/add")
    public ModelAndView addRoute() {
        return new ModelAndView("add-route")
                .addObject("levels", Level.values())
                .addObject("categories", CategoryName.values());
    }

    @PostMapping("/add")
    public ModelAndView addRoute(AddRouteBindingModel addRouteBindingModel) {
        this.routeService.add(addRouteBindingModel);

        return new ModelAndView("add-route");
    }

}
