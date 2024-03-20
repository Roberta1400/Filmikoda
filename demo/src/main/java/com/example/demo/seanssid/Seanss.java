package com.example.demo.seanssid;

import com.example.demo.filmid.Film;
import com.example.demo.saalid.Saal;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Seanss")
public class Seanss {

    @Id
    @SequenceGenerator(
            name = "seanss_sequence",
            sequenceName = "seanss_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seanss_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private LocalDateTime algusaeg;

    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @ManyToOne
    @JoinColumn(name = "saal_id", nullable = false)
    private Saal saal;

    public Seanss() {
    }

    public Seanss(Long id, LocalDateTime algusaeg, Film film, Saal saal) {
        this.id = id;
        this.algusaeg = algusaeg;
        this.film = film;
        this.saal = saal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAlgusaeg() {
        return algusaeg;
    }

    public void setAlgusaeg(LocalDateTime algusaeg) {
        this.algusaeg = algusaeg;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Saal getSaal() {
        return saal;
    }

    public void setSaal(Saal saal) {
        this.saal = saal;
    }

    @Override
    public String toString() {
        return "Seanss{" +
                "id=" + id +
                ", algusaeg=" + algusaeg +
                ", film=" + film +
                ", saal=" + saal +
                '}';
    }
}