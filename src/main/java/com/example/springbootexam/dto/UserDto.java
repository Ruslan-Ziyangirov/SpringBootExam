package com.example.springbootexam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String first_name;
    private String second_name;
    private String login;
    private String email;
    private String password;
}
