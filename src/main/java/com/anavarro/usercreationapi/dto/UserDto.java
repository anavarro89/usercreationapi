package com.anavarro.usercreationapi.dto;

import java.util.List;

public class UserDto {

    private String name;
    private String email;
    private String password;
    //private List<PhoneDto> phones;

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

 //   public List<PhoneDto> getPhones() {
 //       return phones;
 //   }

 //   public void setPhones() {
 //       this.phones = phones;
 //   }
}