package com.example.reservation_spring.business.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Business {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
}
