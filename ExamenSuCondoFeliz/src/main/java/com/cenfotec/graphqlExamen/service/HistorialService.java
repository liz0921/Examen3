package com.cenfotec.graphqlExamen.service;



import com.cenfotec.graphqlExamen.domain.Condominio;
import com.cenfotec.graphqlExamen.domain.Historial;

import java.util.List;
import java.util.Optional;

public interface HistorialService {
    public void save(Historial historial);
    public Optional<Historial> get(Long propietario);
    public List<Historial> getAll();
}
