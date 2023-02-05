package com.example.saparauthorization.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Enumerated(EnumType.STRING)
    @Column
    private String roleName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private List<User> users;

}



