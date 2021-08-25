package dev.djigit99.chesswebsitebackend.models;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Puzzle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Length(max = 100)
    private String description;

    @NotNull
    @Length(max = 100)
    @Column(name = "image_url")
    private String imageUrl;

    @NotNull
    @Length(max = 20)
    @Pattern(regexp = "([RNBKQ]?[a-h][1-8],?)+", message = "Incorrect user moves text format.")
    private String correctUserLine;

    @NotNull
    @Length(max = 100)
    @Pattern(regexp = "([RNBKQ]?[a-h][1-8],?)+", message = "Incorrect opponent moves text format.")
    private String opponentLine;
}
