package com.cenfotec.graphqlExamen.repositories;


import com.cenfotec.graphqlExamen.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepo extends JpaRepository<Persona, Long> {
}
