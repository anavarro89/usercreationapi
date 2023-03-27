package com.anavarro.usercreationapi.mapper;

import com.anavarro.usercreationapi.dto.UserDto;
import com.anavarro.usercreationapi.persistence.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserMapperImpl implements Mapper<UserDto, User> {

    private final PhoneMapperImpl phoneMapper;

    @Autowired
    public UserMapperImpl(PhoneMapperImpl phoneMapper) {
        this.phoneMapper = phoneMapper;
    }

    @Override
    public User mapEntity(UserDto in) {
        User user = new User();
        user.setName(in.getName());
        user.setEmail(in.getEmail());
        user.setPassword(in.getPassword());
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
      //  if(!in.getPhones().isEmpty()) {
      //      user.setPhones(in.getPhones()
        //            .stream()
      //              .map(phoneDto -> phoneMapper.mapEntity(phoneDto))
        //            .collect(Collectors.toList()));
       // }
        return user;
    }

    @Override
    public UserDto mapDto(User in) {
        return UserDto.builder()
                .name(in.getName())
                .email(in.getEmail())
                .password(in.getPassword())
        //        .phones(in.getPhones()
        //                .stream()
        //                .filter(Objects::nonNull)
        //                .map(phone -> phoneMapper.mapDto(phone))
        //                .collect(Collectors.toList()))
                .build();

    }
}
