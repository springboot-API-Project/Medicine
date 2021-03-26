package com.medicine.check.controller.board;


import com.medicine.check.controller.dto.BoardDto;
import com.medicine.check.domain.board.Board;
import com.medicine.check.domain.board.BoardRepository;
import com.medicine.check.service.board.BoardService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BoardApiControllerTest {
    @LocalServerPort
    int port;

    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardRepository boardRepository;

    @After
    public void after() {
        // 한 메소드의 테스트가 끝나고 난 뒤 테스트때 들어간 DB내용 삭제
        boardRepository.deleteAll();
    }


    @Test
    public void save() {
        // given
        // 테스트할 정보 제공? 설정?
        String title = "제목";
        String content = "내용";

        // Setter 없앰
//        Board board = new Board();
//        board.setBrd_title(title);
//        board.setBrd_content(content);
//        board.setMem_id(1L);
//        board.setMem_nickname("test");

        // Builder통해서 setter처럼 값 입력
        Board board = Board.builder()
                .brd_title(title)
                .brd_content(content)
                .mem_id(1L)
                .mem_nickname("test")
                .build();

        // when
        // test 단계
        boardService.save(board);

        // then
        // 테스트 한 후 검증?
        List<Board> boardList = boardRepository.findAll();
        board = boardList.get(boardList.size() -1);

        assertThat(board.getBrd_title()).isEqualTo(title);
        assertThat(board.getBrd_content()).isEqualTo(content);
    }

    @Test
    public void update() {
        // given
        String title = "11111";
        String content = "222222";
        BoardDto dto = BoardDto.builder()
                .brd_id(4L)
                .brd_title(title)
                .brd_content(content)
                .build();
        String url = "http://localhost:" + port + "/api/board/update/" + dto.getBrd_id();

        // when


        // then
    }
}
