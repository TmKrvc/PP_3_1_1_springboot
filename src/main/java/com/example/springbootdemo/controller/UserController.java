package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.User;
import com.example.springbootdemo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/userCreate")
    public String createUserForm(User user) {
        return "userCreate";
    }

    @PostMapping("/userCreate")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/userUpdate/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        User user = userService.findBuId(id);
        model.addAttribute("user", user);
        return "/userUpdate";
    }

    @GetMapping("/userUpdate")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
}
