package com.anavarro.usercreationapi.persistence.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.lang.Long;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id;
    }

    @NotBlank(message = "El número de teléfono es obligatorio")
        private int phone;

    @NotBlank(message = "El código de ciudad es obligatorio")
        private int city_code;

    @NotBlank(message = "El código de país es obligatorio")
        private int country_code;

    @ManyToOne
    @JoinColumn(name = "userId")
    Users user;



        // getters y setters


    public int getPhone() {
        return phone;
    }

    public void setPhone(int number) {
        this.phone = phone;
    }

    public int getCity_code() {
        return city_code;
    }

    public void setCity_code(int cityCode) {
        this.city_code = city_code;
    }

    public int getCountry_code() {
        return country_code;
    }

    public void setCountry_code(int countryCode) {
        this.country_code = country_code;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}

