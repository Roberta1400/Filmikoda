package com.example.demo.kasutaja;


import jakarta.persistence.*;

@Entity
@Table
public class Kasutaja {

    @Id
    @SequenceGenerator(
            name = "kasutaja_sequence",
            sequenceName = "kasutaja_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "kasutaja_sequence"
    )
    private Long id;
    private String kasutajanimi;
    private String email;
    private String parool;

    public Kasutaja() {
    }

    public Kasutaja(Long id, String kasutajanimi, String email, String parool) {
        this.id = id;
        this.kasutajanimi = kasutajanimi;
        this.email = email;
        this.parool = parool;
    }

    public Kasutaja(String kasutajanimi, String email, String parool) {
        this.kasutajanimi = kasutajanimi;
        this.email = email;
        this.parool = parool;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKasutajanimi() {
        return kasutajanimi;
    }

    public void setKasutajanimi(String kasutajanimi) {
        this.kasutajanimi = kasutajanimi;
    }

    public String getParool() {
        return parool;
    }

    public void setParool(String parool) {
        this.parool = parool;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Kasutaja{" +
                "id=" + id +
                ", kasutajanimi='" + kasutajanimi + '\'' +
                ", parool='" + parool + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
