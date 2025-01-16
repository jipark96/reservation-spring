package com.example.reservation_spring.member.repository;

import com.example.reservation_spring.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final SqlSessionTemplate sqlSession;

    //회원가입
    public void memberSave(Member member) {
        sqlSession.insert("com.example.reservation_spring.member.mapper.MemberMapper.memberSave", member);
    }

    //이메일로 회원 조회
    public Member findByEmail(String email) {
        return sqlSession.selectOne("com.example.reservation_spring.member.mapper.MemberMapper.findByEmail", email);
    }
}
