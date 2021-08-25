package dev.djigit99.chesswebsitebackend.repositories;

import dev.djigit99.chesswebsitebackend.models.Puzzle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuzzleRepository extends JpaRepository<Puzzle, Integer> {
    Puzzle findPuzzleById(Integer id);
}
