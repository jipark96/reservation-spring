package com.example.reservation_spring.business.repository;

import com.example.reservation_spring.business.dto.GetBusinessDto;
import com.example.reservation_spring.business.model.Business;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BusinessRepository {

    private final SqlSessionTemplate sqlSession;

    //회원가입
    public void businessSave(Business business) {
        sqlSession.insert("com.example.reservation_spring.business.mapper.BusinessMapper.businessSave", business);
    }

    //이메일로 회원 조회
    public Business findByEmail(String email) {
        return sqlSession.selectOne("com.example.reservation_spring.business.mapper.BusinessMapper.findByEmail", email);
    }

    //회원조회
    public List<GetBusinessDto> findAllBusiness() {
        return sqlSession.selectList("com.example.reservation_spring.business.mapper.BusinessMapper.findAllBusiness");
    }

    //회원 상세 조회
    public GetBusinessDto findByIdBusiness(Long id) {
        return sqlSession.selectOne("com.example.reservation_spring.business.mapper.BusinessMapper.findByIdBusiness", id);
    }

    //회원탈퇴
    public void businessDelete(Long id) {
        sqlSession.delete("com.example.reservation_spring.business.mapper.BusinessMapper.businessDelete", id);
    }

    //회원수정
    public void businessUpdate(Business business) {
        sqlSession.update("com.example.reservation_spring.business.mapper.BusinessMapper.businessUpdate", business);
    }

}
