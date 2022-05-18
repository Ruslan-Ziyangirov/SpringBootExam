package com.example.springbootexam.model;

import lombok.*;

import javax.persistence.*;

@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "login")
    private String login;

    @Column(name = "second_name")
    private String second_name;

    @Column(name = "password")
    private String passwordHash;

    @Column(name = "email")
    private String email;
}
