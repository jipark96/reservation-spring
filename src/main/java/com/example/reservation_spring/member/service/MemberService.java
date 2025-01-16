package com.example.reservation_spring.member.service;

import com.example.reservation_spring.member.dto.JoinRequestDto;
import com.example.reservation_spring.member.dto.JoinResponseDto;
import com.example.reservation_spring.member.dto.LoginRequestDto;
import com.example.reservation_spring.member.dto.LoginResponseDto;
import com.example.reservation_spring.member.model.Member;
import com.example.reservation_spring.member.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    //회원가입
    public JoinResponseDto memberSave(JoinRequestDto joinRequestDto) {

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(joinRequestDto.getPassword());

        // JoinRequestDto를 Member 엔티티로 변환
        Member member = joinRequestDto.toEntity();
        member.setPassword(encodedPassword);

        // DB에 회원 저장
        memberRepository.memberSave(member);

        return new JoinResponseDto("회원가입 성공");
    }

    //로그인
    public LoginResponseDto login(LoginRequestDto loginRequestDto, HttpSession session) {
        Member member = memberRepository.findByEmail(loginRequestDto.getEmail());

        // 회원이 존재하지 않거나 비밀번호가 일치하지 않으면 로그인 실패 처리
        if (member == null || !passwordEncoder.matches(loginRequestDto.getPassword(), member.getPassword())) {
            return new LoginResponseDto("로그인 실패 : 잘못된 이메일 또는 비밀번호");
        }

        // 로그인 성공 시 세션에 사용자 정보 저장
        session.setAttribute("member", member);

        return new LoginResponseDto("로그인 성공");
    }

    // 세션에서 사용자 정보 가져오기
    public Member getLoggedInUser(HttpSession session) {
        return (Member) session.getAttribute("member");
    }

    // 로그아웃
    public void logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
    }
}
