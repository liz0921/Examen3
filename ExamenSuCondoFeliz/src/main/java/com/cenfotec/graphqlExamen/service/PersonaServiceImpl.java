package com.cenfotec.graphqlExamen.service;


import com.cenfotec.graphqlExamen.domain.Persona;
import com.cenfotec.graphqlExamen.repositories.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    PersonaRepo repo;
    @Override
    public Optional<Persona> update(Persona persona) {
        Optional<Persona> record = repo.findById(persona.getId());
        if (record.isPresent()) {
            Persona data = record.get();
            data.setNombre(persona.getNombre());
            return Optional.of(repo.save(data));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Persona> delete(Persona persona) {
        Optional<Persona> record = repo.findById(persona.getId());
        if (record.isPresent()) {
            Persona data = record.get();
            data.setEstado("ex-condómino");
            return Optional.of(repo.save(data));
        }
        return Optional.empty();
    }


   @Override
    public Persona create(String nombre) {
        Persona persona= new Persona();
        persona.setEstado("activo");
        persona.setNombre(nombre);
        return this.repo.save(persona);
    }

    @Override
    public Optional<Persona> save(Persona Persona) {
        return Optional.of(repo.save(Persona));
    }

    @Override
    public Optional<Persona> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public List<Persona> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Persona> getAllPeople(int count) {
        return this.repo.findAll().stream().limit(count).collect(Collectors.toList());
    }
}
