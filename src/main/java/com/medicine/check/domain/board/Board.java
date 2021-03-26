package com.medicine.check.domain.board;

import com.medicine.check.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Board extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brd_id;            // 게시글 id
    private String brd_title;       // 게시글 제목
    private String brd_content;     // 게시글 내용
    private Long mem_id;            // 작성자 id
    private String mem_nickname;    // 작성자 닉네임
    private int brd_hit;            // 게시글 추천 수
    private int brd_like;           // 게시글 좋아요 수

    @Builder
    public Board(String brd_title, String brd_content, Long mem_id, String mem_nickname, int brd_hit, int brd_like) {
        this.brd_title = brd_title;
        this.brd_content = brd_content;
        this.mem_id = mem_id;
        this.mem_nickname = mem_nickname;
        this.brd_hit = brd_hit;
        this.brd_like = brd_like;
    }

    public void update(String brd_title, String brd_content) {
        this.brd_title = brd_title;
        this.brd_content = brd_content;
    }
}
