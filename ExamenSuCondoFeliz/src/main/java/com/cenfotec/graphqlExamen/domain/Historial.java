package com.cenfotec.graphqlExamen.domain;

import javax.persistence.*;

@Entity
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Double  cuota;

    public Historial() {
    }
    public Historial(long id, Double cuota) {
        this.id = id;
        this.cuota = cuota;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getCuota() {
        return cuota;
    }

    public void setCuota(Double cuota) {
        this.cuota = cuota;
    }

}
