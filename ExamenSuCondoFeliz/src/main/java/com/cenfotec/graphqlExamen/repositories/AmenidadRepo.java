package com.cenfotec.graphqlExamen.repositories;

import com.cenfotec.graphqlExamen.domain.Amenidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmenidadRepo extends JpaRepository<Amenidad, Long> {
//    public List<Amenidad> findByCondominio(Condominio condominio);


}

