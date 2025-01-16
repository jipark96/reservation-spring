package com.example.reservation_spring.member.controller;

import com.example.reservation_spring.member.dto.JoinRequestDto;
import com.example.reservation_spring.member.dto.JoinResponseDto;
import com.example.reservation_spring.member.dto.LoginRequestDto;
import com.example.reservation_spring.member.dto.LoginResponseDto;
import com.example.reservation_spring.member.model.Member;
import com.example.reservation_spring.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

        /**
         * 회원가입 API
         * [POST] /member
         */
        @PostMapping("/member")
        public ResponseEntity<JoinResponseDto> memberSave(@RequestBody JoinRequestDto joinRequestDto) {

            JoinResponseDto joinResponseDto = memberService.memberSave(joinRequestDto);

            return ResponseEntity.ok(joinResponseDto);
        }

    /**
     * 로그인 API
     * [POST] /login
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpSession session) {

        LoginResponseDto loginResponseDto = memberService.login(loginRequestDto, session);

        // 로그인 성공 후, member 객체를 JSON 형식으로 반환
        Member loggedInUser = (Member) session.getAttribute("member");
        if (loginResponseDto.getMessage().equals("로그인 성공")) {
            return ResponseEntity.ok(new LoginResponseDto("로그인 성공", loggedInUser));  // member 정보 포함해서 반환
        }

        return ResponseEntity.ok(loginResponseDto);
    }

    /**
     * 로그아웃 API
     * [POST] /logout
     */
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        memberService.logout(session);
        return ResponseEntity.ok("Logout successful");
    }


}
