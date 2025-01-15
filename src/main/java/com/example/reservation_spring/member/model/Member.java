package com.example.reservation_spring.member.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Member {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;

    // 기본값을 false로 설정
    private boolean adminCheck = false;  // 기본적으로 false로 설정

}
