package com.medicine.check.controller.board;

import com.medicine.check.controller.dto.BoardDto;
import com.medicine.check.domain.board.Board;
import com.medicine.check.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.io.PrintWriter;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardService boardService;

    // Post, Get, Put, Delete - CRUD

    @PostMapping("api/board/save")
    public ModelAndView save(@RequestBody Board board) {
        ModelAndView mav = new ModelAndView();

        boolean isSuccess = boardService.save(board);

        if(!isSuccess) {
            PrintWriter p = new PrintWriter(System.out);
            p.println("저장에 실패했습니다.");
            p.close();
        } else {
            mav.setViewName("redirect:board");
        }
        return mav;
    }

    @PutMapping("api/board/update/{brd_id}")
    public Long update(@PathVariable Long brd_id, @RequestBody BoardDto dto) {
        // DTO 를 쓰는 이유: Board 도메인은 디비에 직접적으로 맞닿아? 정보를 교환하는 역할,
        // 정보 변경의 보호를 위해 DTO를 사용
        return boardService.update(brd_id, dto);
    }

    @DeleteMapping("api/board/delete/{brd_id}")
    public void delete(@PathVariable Long brd_id) {
        boardService.delete(brd_id);
    }
}
