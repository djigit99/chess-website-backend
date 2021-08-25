package dev.djigit99.chesswebsitebackend.models;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Length(max = 50)
    private String title;

    @NotNull
    @Length(max = 500)
    private String description;

    private int likes;
    private int views;

    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @ManyToOne
    private User author;
}
