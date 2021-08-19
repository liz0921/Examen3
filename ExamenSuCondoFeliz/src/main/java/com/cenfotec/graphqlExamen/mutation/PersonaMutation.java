package com.cenfotec.graphqlExamen.mutation;

import com.cenfotec.graphqlExamen.domain.Condominio;
import com.cenfotec.graphqlExamen.domain.Persona;
import com.cenfotec.graphqlExamen.service.CondominioService;
import com.cenfotec.graphqlExamen.service.PersonaService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class PersonaMutation implements GraphQLMutationResolver {
    @Autowired
    private CondominioService condominioService;


    public Condominio createCondominio(String nombre, String direccion, String cedulaJuri, String representante, Boolean estado) {
        return this.condominioService.create(  nombre,  direccion,  cedulaJuri,  representante,  estado);
    }
    public Condominio agregarPersonaACondominio(long idPersona, long id) {
        Optional<Condominio> condominio = condominioService.findById(id);
        Optional<Persona> persona = personaService.findById(idPersona);
        if (condominio.isPresent()) {
            personaService.save(persona.get());
            condominio.get().getListaPersona().add(persona.get());
            condominioService.save(condominio.get());
        }
        return condominio.get();
    }

    @Autowired
    private PersonaService personaService;

    public Persona createPersona(String nombre) {
        return this.personaService.create(nombre);
    }
    public Persona updatePersona( Long id,String nombre,String estado) {
        Optional<Persona> persona = this.personaService.findById(id);
        if (persona.isPresent() && persona.get().getEstado()!=("ex-condómino")) {
            Persona personaEntity = persona.get();
            if (nombre != null)
                personaEntity.setNombre(nombre);
            if (estado != null)
                personaEntity.setEstado(estado);
            personaService.save(personaEntity);
            return personaEntity;
        }
        return null;
    }

}
