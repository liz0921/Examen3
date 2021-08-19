package com.cenfotec.graphqlExamen.controller;


import com.cenfotec.graphqlExamen.domain.Persona;
import com.cenfotec.graphqlExamen.service.CondominioService;
import com.cenfotec.graphqlExamen.service.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/persona"})
public class ControllerPersona {
    @Autowired
    private CondominioService condominioService;

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public Persona create(@RequestBody Persona persona) {
        return personaService.save(persona).get();
    }

    @GetMapping
    public List getAll() {
        return personaService.getAll();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Persona> update(@PathVariable("id") long id,
                                             @RequestBody Persona persona) {
        persona.setId(id);
        Optional<Persona> result = personaService.findById(id);
        if (result.isPresent()&& result.get().getEstado().equals("activo")) {
            result= personaService.update(persona);
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/{deletePersona}/{id}")
    public ResponseEntity<Persona> delete(@PathVariable("id") long id,
                                          @RequestBody Persona persona) {
        persona.setId(id);
        Optional<Persona> result = personaService.findById(id);
        if (result.isPresent()&& result.get().getEstado().equals("activo")) {
            result.get().setEstado("ex-condómino");
            result= personaService.delete(persona);
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
