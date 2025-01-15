package com.example.reservation_spring.member.controller;

import com.example.reservation_spring.member.dto.JoinRequestDto;
import com.example.reservation_spring.member.dto.JoinResponseDto;
import com.example.reservation_spring.member.model.Member;
import com.example.reservation_spring.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//    @PostMapping("/member")
//    public ResponseEntity<String> memberSave(@RequestBody Member member) {
//
//        memberService.memberSave(member);
//
//        // 성공적으로 회원가입 처리 후 응답 반환
//        return ResponseEntity.ok("ok");
//    }

        @PostMapping("/member")
        public ResponseEntity<JoinResponseDto> memberSave(@RequestBody JoinRequestDto joinRequestDto) {

            JoinResponseDto responseDto = memberService.memberSave(joinRequestDto);

            return ResponseEntity.ok(responseDto);
        }
}
