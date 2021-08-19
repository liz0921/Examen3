package com.cenfotec.graphqlExamen.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;


@Entity
public class Condominio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String nombre;
    private String direccion;
    private String cedulaJuri;
    private String representante;
    private Boolean estado;
    private int cantidadUnidades;
    private double cuotaCondominal;

    @OneToMany(fetch= FetchType.EAGER)
    private List<Amenidad> listaAmenidad;


   @OneToMany
   @JoinColumn
   @LazyCollection(LazyCollectionOption.FALSE)
    private List<Persona> listaPersona;

    @OneToMany
    @JoinColumn
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Historial> historial;

    public Condominio() {
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Condominio(long id, String nombre, String direccion, String cedulaJuri, String representante, Boolean estado, int cantidadUnidades, double cuotaCondominal) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cedulaJuri = cedulaJuri;
        this.representante = representante;
        this.estado = estado;
        this.cantidadUnidades = cantidadUnidades;
        this.cuotaCondominal = cuotaCondominal;
    }

    public Condominio( String nombre, String direccion, String cedulaJuri, String representante, Boolean estado) {

        this.nombre = nombre;
        this.direccion = direccion;
        this.cedulaJuri = cedulaJuri;
        this.representante = representante;
        this.estado = estado;
    }

    public Condominio(long id, String nombre, String direccion, String cedulaJuri, String representante, Boolean estado, int cantidadUnidades, double cuotaCondominal, List<Amenidad> listaAmenidad, List<Persona> listaPersona, List<Historial> historial) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cedulaJuri = cedulaJuri;
        this.representante = representante;
        this.estado = estado;
        this.cantidadUnidades = cantidadUnidades;
        this.cuotaCondominal = cuotaCondominal;
        this.listaAmenidad = listaAmenidad;
        this.listaPersona = listaPersona;
        this.historial = historial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedulaJuri() {
        return cedulaJuri;
    }

    public void setCedulaJuri(String cedulaJuri) {
        this.cedulaJuri = cedulaJuri;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(int cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public double getCuotaCondominal() {
        return cuotaCondominal;
    }

    public void setCuotaCondominal(double cuotaCondominal) {
        this.cuotaCondominal = cuotaCondominal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Amenidad> getListaAmenidad() {
        return listaAmenidad;
    }

    public void setListaAmenidad(List<Amenidad> listaAmenidad) {
        this.listaAmenidad = listaAmenidad;
    }

   public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public List<Historial> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Historial> historial) {
        this.historial = historial;
    }
}
