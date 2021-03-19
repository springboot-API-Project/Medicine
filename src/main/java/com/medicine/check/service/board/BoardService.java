package com.medicine.check.service.board;


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
}
