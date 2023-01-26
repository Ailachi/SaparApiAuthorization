//package com.example.saparauthorization.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//
//@Getter
//@Setter
//@ToString
//@Entity
//@Table(name = "Users")
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    private String firstName;
//    private String lastName;
//    private String email;
//    private String password;
//    private LocalDate birthDate;
//    private Boolean isDeleted;
//    private Boolean isVerified;
//    private LocalDateTime creationDate;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "roleId")
//    private Role role;
//}
