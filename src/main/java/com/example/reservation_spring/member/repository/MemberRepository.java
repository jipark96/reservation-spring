package com.example.reservation_spring.member.repository;

import com.example.reservation_spring.member.dto.GetMemberDto;
import com.example.reservation_spring.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    //회원조회
    public List<GetMemberDto> findAllMembers() {
        return sqlSession.selectList("com.example.reservation_spring.member.mapper.MemberMapper.findAllMembers");
    }

    //회원 상세 조회
    public GetMemberDto findByIdMember(Long id) {
        return sqlSession.selectOne("com.example.reservation_spring.member.mapper.MemberMapper.findByIdMember", id);
    }

    //회원탈퇴
    public void memberDelete(Long id) {
        sqlSession.delete("com.example.reservation_spring.member.mapper.MemberMapper.memberDelete", id);
    }

    //회원수정
    public void memberUpdate(Member member) {
        sqlSession.update("com.example.reservation_spring.member.mapper.MemberMapper.memberUpdate", member);
    }

}
