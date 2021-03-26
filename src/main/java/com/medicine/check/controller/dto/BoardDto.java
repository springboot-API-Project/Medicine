package com.medicine.check.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardDto {
    private Long brd_id;
    private String brd_title;
    private String brd_content;
    private Long mem_id;
    private int brd_hit;
    private int brd_like;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Builder
    public BoardDto(Long brd_id, String brd_title, String brd_content, Long mem_id, int brd_hit, int brd_like, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.brd_id = brd_id;
        this.brd_title = brd_title;
        this.brd_content = brd_content;
        this.mem_id = mem_id;
        this.brd_hit = brd_hit;
        this.brd_like = brd_like;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
