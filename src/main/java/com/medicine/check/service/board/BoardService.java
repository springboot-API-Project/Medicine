package com.medicine.check.service.board;


import com.medicine.check.domain.board.Board;
import com.medicine.check.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public Board findById(Long blog_id) {
        return boardRepository.findById(blog_id).get();
    }
}
