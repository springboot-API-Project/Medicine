package com.medicine.check.service.board;


import com.medicine.check.controller.dto.BoardDto;
import com.medicine.check.domain.board.Board;
import com.medicine.check.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public Board findById(Long blog_id) {
        return boardRepository.findById(blog_id).get();
    }

    @Transactional(readOnly = true)
    public List<Board> findByAll() {
        return boardRepository.findAll();
    }

    public boolean save(Board board) {
        boolean result = false;

        result = board.getBrd_title().equals(boardRepository.save(board).getBrd_title()) ? true : false;

        return result;
    }

    @Transactional
    public Long update(Long brd_id, BoardDto dto) {
        // update는 JPA에서 따로 지원해주는 메소드가 없어서
        // select해서 정보 있는지 확인하고 controller에서 PutMapping으로 update 실행

        Board board = boardRepository.findById(brd_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        board.update(dto.getBrd_title(), dto.getBrd_content());

        return brd_id;
    }

    public void delete(Long brd_id) {
        boardRepository.deleteById(brd_id);
    }
}
