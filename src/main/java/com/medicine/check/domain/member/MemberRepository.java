package com.medicine.check.domain.member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);             //회원을 저장하면 저장된 회원 반환
    Optional<Member> findById(Long mem_id);     //id가 null이면 Optional으로 감싸서 반환한다
    Optional<Member> findByNickName(String mem_nickname);
    List<Member> findAll();
}
