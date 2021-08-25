package dev.djigit99.chesswebsitebackend.dto.puzzle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PuzzleUpdateDto {
    @NotNull
    private Integer id;

    @Length(max = 100)
    private String description;

    @Length(max = 100)
    private String imageUrl;

    @Length(max = 100)
    @Pattern(regexp = "([RNBKQ]?[a-h][1-8],?)+", message = "Incorrect user moves text format.")
    private String correctUserLine;

    @Size(max = 100)
    @Pattern(regexp = "([RNBKQ]?[a-h][1-8],?)+", message = "Incorrect opponent moves text format.")
    private String opponentLine;
}
