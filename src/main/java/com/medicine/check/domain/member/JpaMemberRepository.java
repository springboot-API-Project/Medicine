package com.medicine.check.domain.member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;
    // jpa는 entitymanager로 동작한다. 스프링부트가 생성해준다. 그 만들어진걸 인젝션 받으면 된다.

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
        // 이렇게만 해도 jpa가 insert 쿼리 다 만들어서 member에 있는 setId까지 다해준다.
    }

    @Override
    public Optional<Member> findById(Long mem_id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByNickName(String mem_nickname) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
