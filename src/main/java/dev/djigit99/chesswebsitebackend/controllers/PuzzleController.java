package dev.djigit99.chesswebsitebackend.controllers;

import dev.djigit99.chesswebsitebackend.dto.puzzle.PuzzleUpdateDto;
import dev.djigit99.chesswebsitebackend.models.Puzzle;
import dev.djigit99.chesswebsitebackend.repositories.PuzzleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("puzzle")
public class PuzzleController {

    @Autowired
    private PuzzleRepository puzzleRepository;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(puzzleRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Puzzle puzzle = puzzleRepository.findPuzzleById(id);
        if (puzzle == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Задача не знайдена.");
        }
        return ResponseEntity.ok(puzzle);
    }

    @PostMapping
    public ResponseEntity<?> addPuzzle(@Valid @RequestBody Puzzle puzzle) {
        Puzzle addedPuzzle = puzzleRepository.save(puzzle);
        return ResponseEntity.ok(addedPuzzle);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updatePuzzle(@Valid @RequestBody PuzzleUpdateDto puzzleDto) {
        Puzzle oldPuzzle = puzzleRepository.findPuzzleById(puzzleDto.getId());

        if (oldPuzzle == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Неможливо редагувати задачу: задача не знайдена.");
        }

        if (puzzleDto.getDescription() != null && !puzzleDto.getDescription().isEmpty()) {
            oldPuzzle.setDescription(puzzleDto.getDescription());
        }
        if (puzzleDto.getImageUrl() != null && !puzzleDto.getImageUrl().isEmpty()) {
            oldPuzzle.setImageUrl(puzzleDto.getImageUrl());
        }
        if (puzzleDto.getCorrectUserLine() != null && !puzzleDto.getCorrectUserLine().isEmpty()) {
            oldPuzzle.setCorrectUserLine(puzzleDto.getCorrectUserLine());
        }
        if (puzzleDto.getOpponentLine() != null && !puzzleDto.getOpponentLine().isEmpty()) {
            oldPuzzle.setOpponentLine(puzzleDto.getOpponentLine());
        }

        return ResponseEntity.ok(puzzleRepository.save(oldPuzzle));
    }
}
