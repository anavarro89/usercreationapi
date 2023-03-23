package com.anavarro.usercreationapi.mapper;

import com.anavarro.usercreationapi.dto.PhoneDto;
import com.anavarro.usercreationapi.dto.UserDto;
import com.anavarro.usercreationapi.persistence.entities.Phone;
import com.anavarro.usercreationapi.persistence.entities.Users;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserDtoInUsers implements IMapper<UserDto, Users> {

    @Override
    public Users map(UserDto in) {
        Users users = new Users();
        users.setName(in.getName());
        users.setEmail(in.getEmail());
        users.setPassword(in.getPassword());
        users.setCreated(LocalDateTime.now());
        users.setModified(LocalDateTime.now());
        users.setActive(false);

        return users;
    }

}
