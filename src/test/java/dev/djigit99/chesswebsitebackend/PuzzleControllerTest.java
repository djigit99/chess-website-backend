package dev.djigit99.chesswebsitebackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.djigit99.chesswebsitebackend.dto.puzzle.PuzzleUpdateDto;
import dev.djigit99.chesswebsitebackend.models.Puzzle;
import dev.djigit99.chesswebsitebackend.repositories.PuzzleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PuzzleControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PuzzleRepository puzzleRepository;

    @BeforeEach
    public void setUp() {
        Puzzle puzzle1 = new Puzzle();
        puzzle1.setDescription("Desc");
        puzzle1.setImageUrl("imageUrl");
        puzzle1.setCorrectUserLine("Kg4,Rf5,e8");
        puzzle1.setOpponentLine("Kh8,Rb6");

        puzzleRepository.save(puzzle1);
    }

    @Test
    public void findTest() throws Exception{
        this.mvc.perform(get("/puzzle/1")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.description").value("Desc"))
            .andExpect(jsonPath("$.imageUrl").value("imageUrl"))
            .andExpect(jsonPath("$.correctUserLine").value("Kg4,Rf5,e8"))
            .andExpect(jsonPath("$.opponentLine").value("Kh8,Rb6"));
    }

    @Test
    public void puzzleSavedTest() throws Exception {
        Puzzle puzzle2 = new Puzzle();
        puzzle2.setDescription("Desc");
        puzzle2.setImageUrl("imageUrl");
        puzzle2.setCorrectUserLine("Kg4,Rf5,e9");
        puzzle2.setOpponentLine("Kh8,Rb6");

        this.mvc.perform(post("/puzzle")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(puzzle2)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("Desc"));
    }

    @Test
    public void correctUserLineAndCorrectOpponentLine_whenUpdate() throws Exception {

        PuzzleUpdateDto dto = new PuzzleUpdateDto(
                1, "Desc", "imageUrl", "Kg4,Rf5,e8", "Kh8,Rb6"
        );

        this.mvc.perform(
                put("/puzzle/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dto))
                        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.correctUserLine").value("Kg4,Rf5,e8"));
    }

    @Test
    public void incorrectUserLine1_whenUpdate() throws Exception {
        PuzzleUpdateDto dto = new PuzzleUpdateDto(
                1, "Desc", "imageUrl", "Kg4,Rf5,e9", "Kh8,Rb6"
        );

        this.mvc.perform(
                        put("/puzzle/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(new ObjectMapper().writeValueAsString(dto))
                );
    }
}
