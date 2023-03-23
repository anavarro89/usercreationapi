package com.anavarro.usercreationapi.services;

import com.anavarro.usercreationapi.dto.PhoneDto;
import com.anavarro.usercreationapi.dto.UserDto;
import com.anavarro.usercreationapi.mapper.UserDtoInUsers;
import com.anavarro.usercreationapi.persistence.entities.Users;
import com.anavarro.usercreationapi.persistence.repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UsersRepository repository;
    private final UserDtoInUsers mapper;

    public UserService(UsersRepository repository, UserDtoInUsers mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Users createUser(UserDto userDto) {
        Users users = mapper.map(userDto);
        return this.repository.save(users);

    }

    public List<Users> findByEmail(Users users) {
        return this.repository.findByEmail(users);
    }
}


