//package com.group01.bits.entity;
//
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Entity
//@Builder
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "session")
//public class Session {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "session_id")
//    private Long sessionID;
//
//    @OneToMany
//    @JoinColumn(name = "user_id")
//    private List<User> users;
//}
