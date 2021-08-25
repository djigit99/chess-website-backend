package dev.djigit99.chesswebsitebackend.models;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Length(max = 30)
    private String title;

    @Length(max = 500)
    private String description;

    private Date date;

    @OneToMany
    @ToString.Exclude
    private List<User> visitors = new ArrayList<>();
}
