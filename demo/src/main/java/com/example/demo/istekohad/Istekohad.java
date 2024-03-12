package com.example.demo.istekohad;

import com.example.demo.saalid.Saal;
import jakarta.persistence.*;

@Entity
public class Istekohad {
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
    private int kohaId;
    private boolean kasVõetud;

    @ManyToOne
    @JoinColumn(name = "saalId", nullable = false)
    private Saal saal;

    public Istekohad() {
    }

    public Istekohad(Long id, int kohaId, boolean kasVõetud, Saal saal) {
        this.id = id;
        this.kohaId = kohaId;
        this.kasVõetud = kasVõetud;
        this.saal = saal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKohaId() {
        return kohaId;
    }

    public void setKohaId(int kohaId) {
        this.kohaId = kohaId;
    }

    public boolean isKasVõetud() {
        return kasVõetud;
    }

    public void setKasVõetud(boolean kasVõetud) {
        this.kasVõetud = kasVõetud;
    }

    public Saal getSaal() {
        return saal;
    }

    public void setSaal(Saal saal) {
        this.saal = saal;
    }

    @Override
    public String toString() {
        return "Istekohad{" +
                "id=" + id +
                ", kohaId=" + kohaId +
                ", kasVõetud=" + kasVõetud +
                ", saal=" + saal +
                '}';
    }
}
