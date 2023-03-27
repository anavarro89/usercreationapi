package com.anavarro.usercreationapi.services;

import com.anavarro.usercreationapi.dto.UserDto;
import com.anavarro.usercreationapi.exception.UserNotCreatedException;
import com.anavarro.usercreationapi.exception.UserNotFoundException;
import com.anavarro.usercreationapi.mapper.UserMapperImpl;
import com.anavarro.usercreationapi.persistence.entities.User;
import com.anavarro.usercreationapi.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository repository;
    private final UserMapperImpl mapper;

    public UserService(UserRepository repository, UserMapperImpl mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public User createUser(UserDto userDto) {
        User user = mapper.mapEntity(userDto);
        user.setActive(true);
        user = this.repository.save(user);
        if(Objects.isNull(user.getId())){
            throw new UserNotCreatedException("Usuario no pudo ser creado");

        }
        return this.repository.save(user);

    }

    public UserDto findByEmail(String email) {
        Optional<User> userFound = this.repository.findByEmail(email);
        if(!userFound.isPresent()){
           throw new UserNotFoundException("EL usuario no esta registrado");
        }
       return mapper.mapDto(userFound.get());
    }

}


