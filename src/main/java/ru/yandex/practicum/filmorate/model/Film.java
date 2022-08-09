package ru.yandex.practicum.filmorate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.minidev.json.annotate.JsonIgnore;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Film {
    private Integer id;
    @NotBlank
    private String description;
    @NotBlank
    private String name;
    private LocalDate releaseDate;
    private Set<Genre> genres;
    @NotNull
    private Mpa ratingMpa;
    @Positive
    private Integer duration;
    @JsonIgnore
    private Set<Integer> userId = new HashSet<>();

    public Film(int film_id, String films_name, String description,
                int duration, LocalDate release_date, Mpa mpa) {
        this.id=film_id;
        this.name = films_name;
        this.description = description;
        this.duration = duration;
        this.releaseDate = release_date;
        this.ratingMpa = mpa;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id.equals(film.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
