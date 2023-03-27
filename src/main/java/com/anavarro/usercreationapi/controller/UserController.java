package com.anavarro.usercreationapi.controller;

import com.anavarro.usercreationapi.dto.UserDto;
import com.anavarro.usercreationapi.persistence.entities.User;
import com.anavarro.usercreationapi.services.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@ComponentScan(basePackages = "com.anavarro.usercreationapi")
@RequestMapping("/user")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity createUsers(@RequestBody @Valid UserDto userDto){
        User userCreated = this.userService.createUser(userDto);
        return ResponseEntity.created(URI.create("/" + userCreated.getId())).body(userCreated);
    }

    @GetMapping("/{email}")
    public UserDto findByEmail(@PathVariable("email") String email){
        return this.userService.findByEmail(email);
    }
}



