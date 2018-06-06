package com.bh.springboot2.controller;

import com.bh.springboot2.model.User;
import com.bh.springboot2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping ("person/save")
    public User save(@RequestParam(required = false) String name){
        User user = new User();
        user.setName(name);
        if (userRepository.save(user)){
            System.out.println("用户对象信息"+user);
        }
        return user;
    }
}
