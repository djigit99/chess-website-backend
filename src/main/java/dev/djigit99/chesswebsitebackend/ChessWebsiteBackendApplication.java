package dev.djigit99.chesswebsitebackend;

import dev.djigit99.chesswebsitebackend.models.Puzzle;
import dev.djigit99.chesswebsitebackend.repositories.PuzzleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChessWebsiteBackendApplication implements CommandLineRunner {

    @Autowired
    PuzzleRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(ChessWebsiteBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Puzzle puzzle = new Puzzle();
        puzzle.setDescription("Desc");
        puzzle.setImageUrl("/puzzles/1roz_20.jpg");
        puzzle.setCorrectUserLine("Ke4");
        puzzle.setOpponentLine("Ke5");

        repo.save(puzzle);
    }
}
