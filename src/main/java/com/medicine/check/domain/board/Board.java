package com.medicine.check.domain.board;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brd_id;            // 게시글 id
    private String brd_title;       // 게시글 제목
    private String brd_content;     // 게시글 내용
    private Long mem_id;            // 작성자 id
    private String mem_nickname;    // 작성자 닉네임
    private int brd_hit;            // 게시글 추천 수
    private int brd_like;           // 게시글 좋아요 수

}
