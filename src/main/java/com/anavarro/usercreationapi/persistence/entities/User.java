package com.anavarro.usercreationapi.persistence.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

   // @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    //private List<Phone> phones;

    @CreationTimestamp

    private LocalDateTime created;

    @UpdateTimestamp

    private LocalDateTime modified;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;


    private String token;

    @Column(name = "is_active")
    private boolean isActive;

}