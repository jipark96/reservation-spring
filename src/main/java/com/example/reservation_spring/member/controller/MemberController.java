package com.example.reservation_spring.member.controller;

import com.example.reservation_spring.member.dto.*;
import com.example.reservation_spring.member.model.Member;
import com.example.reservation_spring.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "member 도메인", description = "회원가입 API, 로그인 API, 유저 정보 조회 API")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

        /**
         * 회원가입 API
         * [POST] /member
         */
        @Operation(summary = "회원가입")
        @PostMapping("/member")
        public ResponseEntity<JoinResponseDto> memberSave(@RequestBody JoinRequestDto joinRequestDto) {

            JoinResponseDto joinResponseDto = memberService.memberSave(joinRequestDto);

            return ResponseEntity.ok(joinResponseDto);
        }

    /**
     * 로그인 API
     * [POST] /login
     */
    @Operation(summary = "로그인")
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
    @Operation(summary = "로그아웃")
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        memberService.logout(session);
        return ResponseEntity.ok("Logout successful");
    }


    /**
     * 회원조회 API
     * [GET] /member
     */
    @Operation(summary = "회원 조회")
    @GetMapping("/member")
    public ResponseEntity<List<GetMemberDto>> findAllMembers() {
        List<GetMemberDto> getMemberDtoList = memberService.findAllMembers();
        return ResponseEntity.ok(getMemberDtoList);
    }

    /**
     * 회원상세조회
     * [GET] /member/{id}
     */
    @Operation(summary = "회원 상세 조회")
    @GetMapping("/member/{id}")
    public ResponseEntity<GetMemberDto> findByIdMember(@PathVariable Long id) {
        GetMemberDto getMemberDto = memberService.findByIdMember(id);
        return ResponseEntity.ok(getMemberDto);
    }

    /**
     * 회원탈퇴
     * [DELETE] /member/{id}
     */
    @Operation(summary = "회원 탈퇴")
    @DeleteMapping("/member/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {
        memberService.memberDelete(id);
        return ResponseEntity.ok("Delete successful");
    }

    /**
     * 회원수정
     * [PATCH] /member/update/{id}
     */
    @Operation(summary = "회원 수정")
    @PatchMapping("/member/update/{id}")
    public ResponseEntity<PatchMemberDto> updateMember(@PathVariable Long id, @RequestBody  PatchMemberDto patchMemberDto) {
        patchMemberDto.setId(id);
        memberService.memberUpdate(patchMemberDto);
        return ResponseEntity.ok(patchMemberDto);
    }

}
