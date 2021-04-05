package com.medicine.check.controller.board;

import com.medicine.check.service.board.BoardService;
import com.medicine.check.domain.board.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller     // Bean 주입
@RequiredArgsConstructor    // 생성자
public class BoardController {
    // DI - 생성자 주입
    /*
    - 생성자 주입 : 생성자를 생성해서 주입
    - 필드 주입 : @Inject/ @Autowired
     */
    private final BoardService boardService;


    @RequestMapping("board")
    public String board(Model model) {
        List<Board> boardList = boardService.findByAll();

        model.addAttribute("boardList", boardList);

        return "board/blog";
    }

    @RequestMapping("board-detail")
    public String board_detail(@Param("brd_id") Long brd_id, Model model) {
        Board board = boardService.findById(brd_id);

        model.addAttribute("board", board);

        return "blog-details";
    }

    @RequestMapping("board/save")
    public String save_form(Model model) {
        // Todo: 블로그 CRUD

        model.addAttribute("session", 100L);      // test용, 지워야 할 것
        model.addAttribute("mem_nickname", "테스트용 닉네임");      // test용, 지워야 할 것

        return "board/save_form";
    }

    @RequestMapping("board/update")
    public String update_form(@Param("brd_id") Long brd_id, Model model) {
        Board board = boardService.findById(brd_id);

        model.addAttribute("board", board);

        return "";
    }

}
