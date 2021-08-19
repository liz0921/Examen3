package com.cenfotec.graphqlExamen.service;


import com.cenfotec.graphqlExamen.domain.Amenidad;
import com.cenfotec.graphqlExamen.repositories.AmenidadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmenidadServiceImpl implements AmenidadService {

    @Autowired
    AmenidadRepo amenidadRepo;

    @Override
    public List<Amenidad> getAll() {
        return amenidadRepo.findAll();
    }

/*
    @Override
    public List<Amenidad> findByCondominio(Condominio condominio) {
        return amenidadRepo.findByCondominio(condominio);
    }
*/


    @Override
    public Optional<Amenidad> findById(long id) {
        return Optional.empty();
    }


    @Override
    public Optional<Amenidad> save(Amenidad amenidad) {
        return Optional.of(amenidadRepo.save(amenidad));
    }






}
