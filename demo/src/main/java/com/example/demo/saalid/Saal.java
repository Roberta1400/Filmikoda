package com.example.demo.saalid;

import jakarta.persistence.*;

@Entity
public class Saal {
    @Id
    @SequenceGenerator(
            name = "saal_sequence",
            sequenceName = "saal_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "saal_sequence"
    )
    private Long id;
    private String nimi;

    public Saal() {
    }

    public Saal(String nimi) {
        this.nimi = nimi;
    }

    public Saal(Long id, String nimi) {
        this.id = id;
        this.nimi = nimi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public String toString() {
        return "Saal{" +
                "id=" + id +
                ", nimi='" + nimi + '\'' +
                '}';
    }
}