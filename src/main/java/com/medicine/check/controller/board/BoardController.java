package com.medicine.check.controller.board;

import com.medicine.check.service.board.BoardService;
import com.medicine.check.domain.board.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller     // Bean 주입
@RequiredArgsConstructor    // 생성자
public class BoardController {
    // DI - 생성자 주입
    private final BoardService boardService;

    @RequestMapping("board")
    public String board() {
        return "blog";
    }

    @RequestMapping("board-detail")
    public String board_detail(@Param("brd_id") Long brd_id, Model model) {
        Board board = boardService.findById(brd_id);

        model.addAttribute("board", board);

        return "blog-details";
    }

    @RequestMapping("board/save")
    public String save_form() {
        // Todo: 블로그 CRUD
        return "";
    }

    @RequestMapping("board/update")
    public String update_form(@Param("brd_id") Long brd_id, Model model) {
        Board board = boardService.findById(brd_id);

        model.addAttribute("board", board);

        return "";
    }

}
