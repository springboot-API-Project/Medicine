package com.medicine.check.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("SELECT b FROM Board b WHERE b.brd_title=?1")            // JPQL
    Optional<Board> findByTitle(String brd_title);
}
