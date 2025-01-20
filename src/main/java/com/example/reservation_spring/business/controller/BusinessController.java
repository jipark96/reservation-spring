package com.example.reservation_spring.business.controller;


import com.example.reservation_spring.business.dto.*;
import com.example.reservation_spring.business.model.Business;
import com.example.reservation_spring.business.service.BusinessService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "business 도메인", description = "회원가입 API, 로그인 API, business 정보 조회 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/business")
public class BusinessController {

    private final BusinessService businessService;

    /**
     * Business 회원가입 API
     * [POST] /business
     */
    @Operation(summary = "business 회원가입")
    @PostMapping("")
    public ResponseEntity<JoinResponseDto> businessSave(@RequestBody JoinRequestDto joinRequestDto) {

        JoinResponseDto joinResponseDto = businessService.businessSave(joinRequestDto);

        return ResponseEntity.ok(joinResponseDto);
    }

    /**
     * 로그인 API
     * [POST] /business/login
     */
    @Operation(summary = "로그인")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpSession session) {
        LoginResponseDto loginResponseDto = businessService.login(loginRequestDto, session);

        // 로그인 성공 후, business 객체를 JSON 형식으로 반환
        Business loggedInBusiness = (Business) session.getAttribute("business");
        if (loginResponseDto.getMessage().equals("로그인 성공")) {
            return ResponseEntity.ok(new LoginResponseDto("로그인 성공", loggedInBusiness));
        }
        return ResponseEntity.ok(loginResponseDto);
    }

    /**
     * business 회원조회 API
     * [GET] /business
     */
    @Operation(summary = "회원 조회")
    @GetMapping("")
    public ResponseEntity<List<GetBusinessDto>> findAllBusiness() {
        List<GetBusinessDto> getBusinessDtoList = businessService.findAllBusiness();
        return ResponseEntity.ok(getBusinessDtoList);
    }

    /**
     * 상세조회 API
     * [GET] /business/{id}
     */
    @Operation(summary = "business 회원 상세 조회")
    @GetMapping("/{id}")
    public ResponseEntity<GetBusinessDto> findByIdBusiness(@PathVariable Long id) {
        GetBusinessDto getBusinessDto = businessService.findByIdBusiness(id);
        return ResponseEntity.ok(getBusinessDto);
    }

    /**
     * 회원 탈퇴
     * [DELETE] /business/{id}
     */
    @Operation(summary = "회원 탈퇴")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBusiness(@PathVariable Long id) {
        businessService.businessDelete(id);
        return ResponseEntity.ok("Delete successful");
    }

    /**
     * 회원수정
     * [PATCH] /business/update/{id}
     */
    @Operation(summary = "business 회원 수정")
    @PatchMapping("/update/{id}")
    public ResponseEntity<PatchBusinessDto> updateBusiness(@PathVariable Long id, @RequestBody PatchBusinessDto patchBusinessDto) {
        patchBusinessDto.setId(id);
        businessService.businessUpdate(patchBusinessDto);
        return ResponseEntity.ok(patchBusinessDto);
    }

}
