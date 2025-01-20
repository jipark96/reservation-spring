package com.example.reservation_spring.business.dto;


import com.example.reservation_spring.business.model.Business;
import com.example.reservation_spring.member.model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JoinRequestDto {

    private String name;
    private String email;
    private String password;
    private String phone;

    //JoinRequestDto를 Business 엔티티로 변환하는 메서드
    public Business toEntity() {
        return Business.builder()
                .name(this.name)
                .email(this.email)
                .password(this.password)
                .phone(this.phone)
                .build();
    }
}
