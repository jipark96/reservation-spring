package com.example.reservation_spring.member.service;

import com.example.reservation_spring.member.dto.JoinRequestDto;
import com.example.reservation_spring.member.dto.JoinResponseDto;
import com.example.reservation_spring.member.model.Member;
import com.example.reservation_spring.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //회원가입
//    public void memberSave(Member member) {
//        memberRepository.memberSave(member);
//    }

    //회원가입
    public JoinResponseDto memberSave(JoinRequestDto joinRequestDto) {

        // JoinRequestDto를 Member 엔티티로 변환
        Member member = joinRequestDto.toEntity();

        // DB에 회원 저장
        memberRepository.memberSave(member);

        return new JoinResponseDto("회원가입 성공");

    }
}
