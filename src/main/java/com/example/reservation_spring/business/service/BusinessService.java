package com.example.reservation_spring.business.service;


import com.example.reservation_spring.business.dto.*;
import com.example.reservation_spring.business.model.Business;
import com.example.reservation_spring.business.repository.BusinessRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BusinessService {

    private final BusinessRepository businessRepository;
    private final PasswordEncoder passwordEncoder;

    // Business 회원가입
    public JoinResponseDto businessSave(JoinRequestDto joinRequestDto) {

        //비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(joinRequestDto.getPassword());

        // JoinRequestDto를 Member 엔티티로 변환
        Business business = joinRequestDto.toEntity();
        business.setPassword(encodedPassword);

        // DB에 저장
        businessRepository.businessSave(business);

        return new JoinResponseDto("가입 성공");
    }

    // Business 로그인
    public LoginResponseDto login(LoginRequestDto loginRequestDto, HttpSession session) {
        Business business = businessRepository.findByEmail(loginRequestDto.getEmail());

        // 로그인 실패 시
        if (business == null || !passwordEncoder.matches(loginRequestDto.getPassword(), business.getPassword())) {
            return new LoginResponseDto("로그인 실패 : 잘못된 이메일 또는 비밀번호");
        }

        // 로그인 성공 시 세션에 정보 저장
        session.setAttribute("business", business);

        return new LoginResponseDto("로그인 성공",business);
    }

    // 로그아웃
    public void logout(HttpSession session) {
        session.removeAttribute("business");
    }

    // Business 조회
    public List<GetBusinessDto> findAllBusiness() {
        return businessRepository.findAllBusiness();
    }

    // 상세 조회
    public GetBusinessDto findByIdBusiness(Long id) {
        return businessRepository.findByIdBusiness(id);
    }

    // 탈퇴
    public void businessDelete(Long id) {
        businessRepository.businessDelete(id);
    }

    // 정보 수정
    public void businessUpdate(PatchBusinessDto patchBusinessDto) {
        businessRepository.businessUpdate(patchBusinessDto.toEntity());
    }


}
