package com.cenfotec.graphqlExamen.repositories;

import com.cenfotec.graphqlExamen.domain.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CondominioRepo extends JpaRepository<Condominio, Long> {
    public List<Condominio> findByEstado(Boolean estado);


}

