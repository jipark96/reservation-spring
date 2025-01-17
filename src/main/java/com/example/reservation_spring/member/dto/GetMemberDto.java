package com.example.reservation_spring.member.dto;

import com.example.reservation_spring.member.model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetMemberDto {

    private Long id;
    private String name;
    private String email;
    private String phone;


    public GetMemberDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.email = member.getEmail();
        this.phone = member.getPhone();
    }


}


