package dev.djigit99.chesswebsitebackend.models;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "chess_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @NotNull
    private int id;

    @NotNull
    @Length(max = 24)
    private String login;

    @NotNull
    @Length(min = 1, max = 30)
    private String name;

    @Length(max = 30)
    private String lastname;

    @NotNull
    @Length(max = 40)
    @Email
    private String email;
}
