package com.example.Spring_HW_3.controllers;

import com.example.Spring_HW_3.domain.User;
import com.example.Spring_HW_3.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
//        return service.getDataProcessingService().getRepository().getUsers();
        return service.getDataProcessingService().getRepository().findAll();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
//        service.getDataProcessingService().getRepository().getUsers().add(user);
        service.processRegistration(user.getName(), user.getAge(), user.getEmail());
        return "User added from body!";
    }
    @GetMapping ("/param")
    @ResponseBody
    public String userAddFromParam(@RequestParam String name, @RequestParam int age,
                                 @RequestParam String email) {
        service.processRegistration(name, age, email);
        return "The user was successfully created from the HTTP request parameters!";
    }
}