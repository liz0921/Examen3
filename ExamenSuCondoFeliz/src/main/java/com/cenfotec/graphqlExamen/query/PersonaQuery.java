package com.cenfotec.graphqlExamen.query;

import com.cenfotec.graphqlExamen.domain.Condominio;
import com.cenfotec.graphqlExamen.domain.Persona;
import com.cenfotec.graphqlExamen.service.CondominioService;
import com.cenfotec.graphqlExamen.service.PersonaService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonaQuery implements GraphQLQueryResolver {
    @Autowired
    private PersonaService personaService;
    public List<Persona> getPersonas(int count) {
        return this.personaService.getAllPeople(count);
    }
    public Optional<Persona> getPersona(int id) {
        return this.personaService.findById(id);
    }
    @Autowired
    private CondominioService condominioService;
    public List<Condominio> getCondominios(int count) {
        return this.condominioService.getAllCondominio(count);
    }
    public Optional<Condominio> getCondominio(int id) {
        return this.condominioService.findById(id);
    }

}
