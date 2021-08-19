package com.cenfotec.graphqlExamen.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Amenidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String AmeniSeguridad;
    private String AmeniPiscina;
    private String AmeniClub;
    private String AmeniGym;
    private String AmeniPetGarden;
    private String AmeniParqueJuegos;
    private String AmeniCanchas;

    public Amenidad() {
    }

    public Amenidad(String ameniSeguridad, String ameniPiscina, String ameniClub, String ameniGym, String ameniPetGarden, String ameniParqueJuegos, String ameniCanchas) {
        AmeniSeguridad = ameniSeguridad;
        AmeniPiscina = ameniPiscina;
        AmeniClub = ameniClub;
        AmeniGym = ameniGym;
        AmeniPetGarden = ameniPetGarden;
        AmeniParqueJuegos = ameniParqueJuegos;
        AmeniCanchas = ameniCanchas;
    }

    public Amenidad(long id, String ameniSeguridad, String ameniPiscina, String ameniClub, String ameniGym, String ameniPetGarden, String ameniParqueJuegos, String ameniCanchas) {
        this.id = id;
        AmeniSeguridad = ameniSeguridad;
        AmeniPiscina = ameniPiscina;
        AmeniClub = ameniClub;
        AmeniGym = ameniGym;
        AmeniPetGarden = ameniPetGarden;
        AmeniParqueJuegos = ameniParqueJuegos;
        AmeniCanchas = ameniCanchas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAmeniSeguridad() {
        return AmeniSeguridad;
    }

    public void setAmeniSeguridad(String ameniSeguridad) {
        AmeniSeguridad = ameniSeguridad;
    }

    public String getAmeniPiscina() {
        return AmeniPiscina;
    }

    public void setAmeniPiscina(String ameniPiscina) {
        AmeniPiscina = ameniPiscina;
    }

    public String getAmeniClub() {
        return AmeniClub;
    }

    public void setAmeniClub(String ameniClub) {
        AmeniClub = ameniClub;
    }

    public String getAmeniGym() {
        return AmeniGym;
    }

    public void setAmeniGym(String ameniGym) {
        AmeniGym = ameniGym;
    }

    public String getAmeniPetGarden() {
        return AmeniPetGarden;
    }

    public void setAmeniPetGarden(String ameniPetGarden) {
        AmeniPetGarden = ameniPetGarden;
    }

    public String getAmeniParqueJuegos() {
        return AmeniParqueJuegos;
    }

    public void setAmeniParqueJuegos(String ameniParqueJuegos) {
        AmeniParqueJuegos = ameniParqueJuegos;
    }

    public String getAmeniCanchas() {
        return AmeniCanchas;
    }

    public void setAmeniCanchas(String ameniCanchas) {
        AmeniCanchas = ameniCanchas;
    }
}
