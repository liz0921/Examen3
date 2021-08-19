package com.cenfotec.graphqlExamen.service;


import com.cenfotec.graphqlExamen.domain.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    public  Optional<Persona> update(Persona persona);
    public  Optional<Persona> delete(Persona persona);

    public Persona create(String nombre);
  /* public Persona create(String nombre,String estado);*/

    public Optional<Persona> save(Persona Persona);
    public Optional<Persona> findById(long id);
    public List<Persona> getAll();
    public List<Persona> getAllPeople(int count);
}
