package com.example.reservation_spring.member.service;

import com.example.reservation_spring.member.dto.*;
import com.example.reservation_spring.member.model.Member;
import com.example.reservation_spring.member.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
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

    // 로그아웃
    public void logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
    }

    //회원조회
    public List<GetMemberDto> findAllMembers() {
        return memberRepository.findAllMembers();
    }

    //회원 상세 조회
    public GetMemberDto findByIdMember(Long id) {
        return memberRepository.findByIdMember(id);
    }

    //회원탈퇴
    public void memberDelete(Long id) {
        memberRepository.memberDelete(id);
    }

    //회원수정
    public void memberUpdate(PatchMemberDto patchMemberDto ) {
        memberRepository.memberUpdate(patchMemberDto.toEntity());
    }
}
