package com.example.reservation_spring.member.dto;


import com.example.reservation_spring.member.model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponseDto {

    private String message; //로그인 결과 메시지
    private Member member;  // 로그인한 사용자 정보를 추가

    // 기본 생성자 (회원 정보 없이 메시지만 반환하는 경우를 위해)
    public LoginResponseDto(String message) {
        this.message = message;
    }
}
