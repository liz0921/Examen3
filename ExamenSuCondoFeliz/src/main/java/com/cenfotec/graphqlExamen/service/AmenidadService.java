package com.cenfotec.graphqlExamen.service;


import com.cenfotec.graphqlExamen.domain.Amenidad;

import java.util.List;
import java.util.Optional;

public interface AmenidadService {
    public Optional<Amenidad> save(Amenidad Amenidad);
    public Optional<Amenidad> findById(long id);
    public List<Amenidad> getAll();
//    public List<Amenidad> findByCondominio(Condominio condominio);

}
