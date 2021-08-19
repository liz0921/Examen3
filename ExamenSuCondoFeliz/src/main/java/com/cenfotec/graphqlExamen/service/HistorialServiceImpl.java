package com.cenfotec.graphqlExamen.service;

import com.cenfotec.graphqlExamen.domain.Condominio;
import com.cenfotec.graphqlExamen.domain.Historial;
import com.cenfotec.graphqlExamen.repositories.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialServiceImpl implements HistorialService {
    @Autowired
    HistorialRepository repo;
    @Override
    public void save(Historial historial) {
        repo.save(historial);
    }

    @Override
    public Optional<Historial> get(Long propietario) {
        return repo.findById(propietario);
    }

    @Override
    public List<Historial> getAll() {
        return repo.findAll();
    }



}
