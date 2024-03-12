package com.example.demo.filmid;

import jakarta.persistence.*;

@Entity
@Table(name = "filmid")
public class Film {

    @Id
    @SequenceGenerator(
            name = "film_sequence",
            sequenceName = "film_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "film_sequence"
    )
    private Long id;
    private String pealkiri;
    private String žanr;
    private int vanusepiirang;
    private String keel;

    public Film() {
    }

    public Film(Long id, String pealkiri, String žanr, int vanusepiirang, String keel) {
        this.id = id;
        this.pealkiri = pealkiri;
        this.žanr = žanr;
        this.vanusepiirang = vanusepiirang;
        this.keel = keel;
    }

    public Film(String pealkiri, String žanr, int vanusepiirang, String keel) {
        this.pealkiri = pealkiri;
        this.žanr = žanr;
        this.vanusepiirang = vanusepiirang;
        this.keel = keel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPealkiri() {
        return pealkiri;
    }

    public void setPealkiri(String pealkiri) {
        this.pealkiri = pealkiri;
    }

    public String getŽanr() {
        return žanr;
    }

    public void setŽanr(String žanr) {
        this.žanr = žanr;
    }

    public int getVanusepiirang() {
        return vanusepiirang;
    }

    public void setVanusepiirang(int vanusepiirang) {
        this.vanusepiirang = vanusepiirang;
    }

    public String getKeel() {
        return keel;
    }

    public void setKeel(String keel) {
        this.keel = keel;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", pealkiri='" + pealkiri + '\'' +
                ", žanr='" + žanr + '\'' +
                ", vanusepiirang=" + vanusepiirang +
                ", keel='" + keel + '\'' +
                '}';
    }
}