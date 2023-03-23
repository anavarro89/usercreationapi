package com.anavarro.usercreationapi.persistence.repository;

import com.anavarro.usercreationapi.persistence.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {


    List<Users> findByEmail(Users users);
}