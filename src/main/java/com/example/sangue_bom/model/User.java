package com.example.sangue_bom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "userInfo")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String cpf;
    private String rg;
    private String bloodType;
    private String gender;
    private LocalDate birthDate;
    private String phoneNumber;
    private String city;
    private String state;
    private String zipCode;
    private String street;
    private String houseNumber;
    private String neighborhood;
    private String complement;
    private String role;

}
