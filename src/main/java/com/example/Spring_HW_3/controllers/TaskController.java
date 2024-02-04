package com.example.Spring_HW_3.controllers;

import com.example.Spring_HW_3.domain.User;
import com.example.Spring_HW_3.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge()
    {
//        return service.sortUsersByAge(service.getRepository().getUsers());
        return service.sortUsersByAge(service.getRepository().findAll());//+
    }

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable ("age") int age) {
//        return service.filterUsersByAge(service.getRepository().getUsers(), age);
        return service.filterUsersByAge(service.getRepository().findAll(), age);//+
    }

    @GetMapping("/calc")
    public double calculateAverageAge() {
//        return service.calculateAverageAge(service.getRepository().getUsers());
        return service.calculateAverageAge(service.getRepository().findAll());//+
    }
}
