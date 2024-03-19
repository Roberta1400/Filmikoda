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
    private String vanusepiirang;
    private String keel;

    private String pilt;

    public Film() {
    }

    public Film(Long id, String pealkiri, String žanr, String vanusepiirang, String keel, String pilt) {
        this.id = id;
        this.pealkiri = pealkiri;
        this.žanr = žanr;
        this.vanusepiirang = vanusepiirang;
        this.keel = keel;
        this.pilt = pilt;
    }

    public Film(String pealkiri, String žanr, String vanusepiirang, String keel, String pilt) {
        this.pealkiri = pealkiri;
        this.žanr = žanr;
        this.vanusepiirang = vanusepiirang;
        this.keel = keel;
        this.pilt = pilt;
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

    public String getVanusepiirang() {
        return vanusepiirang;
    }

    public void setVanusepiirang(String vanusepiirang) {
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

    public String getPilt() {
        return pilt;
    }

    public void setPilt(String pilt) {
        this.pilt = pilt;
    }
}