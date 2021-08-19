package com.cenfotec.graphqlExamen.repositories;

import com.cenfotec.graphqlExamen.domain.Condominio;
import com.cenfotec.graphqlExamen.domain.Historial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistorialRepository extends JpaRepository<Historial, Long> {

}