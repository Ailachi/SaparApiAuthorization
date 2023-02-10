package com.example.saparauthorization.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthDate;
    private Boolean isDeleted;
    @Transient
    private Boolean isVerified;
    @Transient
    private LocalDateTime creationDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId")
    private Role role;

}
