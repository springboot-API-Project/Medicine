package com.medicine.check.domain.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mem_id;            // 회원 id
    private String mem_email;       // 회원 이메일
    private String mem_password;    // 회원 비밀번호
    private String mem_nickname;    // 회원 닉네임

}
