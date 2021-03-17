package com.medicine.check.controller.board;

import com.medicine.check.domain.board.Board;
import com.medicine.check.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardService boardService;

    @PostMapping("api/board/save")
    public ModelAndView save() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("blog");

        return mav;
    }

    @PutMapping("api/board/update")
    public ModelAndView update(@Param("brd_id") Long brd_id, @RequestBody Board board) {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("board-detail?" + brd_id);

        return mav;
    }

    @DeleteMapping("api/board/delete")
    public ModelAndView delete(@Param("brd_id") Long brd_id) {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("/");

        return mav;
    }
}
