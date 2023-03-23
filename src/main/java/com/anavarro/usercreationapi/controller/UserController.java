package com.anavarro.usercreationapi.controller;

import com.anavarro.usercreationapi.dto.UserDto;
import com.anavarro.usercreationapi.persistence.entities.Users;
import com.anavarro.usercreationapi.services.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@ComponentScan(basePackages = "com.anavarro.usercreationapi")
@RequestMapping("/api")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public Users createUsers(@RequestBody UserDto userDto){
        return this.userService.createUser(userDto);
    }

    @GetMapping("/email/{email}")
    public List<Users> findByEmail(@PathVariable("email") Users users){
        return this.userService.findByEmail(users);
    }
}



