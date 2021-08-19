package com.cenfotec.graphqlExamen.service;


import com.cenfotec.graphqlExamen.domain.Condominio;

import java.util.List;
import java.util.Optional;

public interface CondominioService {
    public  Optional<Condominio> save(Condominio condominio);

    public Optional<Condominio> findById(long id);
    public  Optional<Condominio> update(Condominio condominio);
    public  Optional<Condominio> desactivar(Condominio condominio);
    public Condominio create( String nombre, String direccion,String cedulaJuri, String representante, Boolean estado);
    public List<Condominio> getAllCondominio(int count);
    public boolean delete(Long id);
    public List<Condominio> getAll();
    public List<Condominio> findtrue(Boolean estado);
    public List<Condominio> findfalse(Boolean estado);


}
