package pl.edu.wat.ai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.wat.ai.services.UserServiceImpl;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;
}