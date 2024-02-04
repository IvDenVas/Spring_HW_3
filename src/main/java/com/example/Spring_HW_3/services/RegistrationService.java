package com.example.Spring_HW_3.services;

import com.example.Spring_HW_3.domain.User;
import org.springframework.stereotype.Service;


@Service
public class RegistrationService {
    private final UserService userService;
    private final NotificationService notificationService;
    private final DataProcessingService dataProcessingService;

    public RegistrationService(UserService userService, NotificationService notificationService, DataProcessingService dataProcessingService) {
        this.userService = userService;
        this.notificationService = notificationService;
        this.dataProcessingService = dataProcessingService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public void processRegistration(String n, int age, String em){
        User user = userService.createUser(n,age,em);
        dataProcessingService.addUserToList(user);
        notificationService.notifyUser(user);
    }


}
