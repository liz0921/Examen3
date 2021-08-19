package com.cenfotec.graphqlExamen.controller;


import com.cenfotec.graphqlExamen.domain.Amenidad;
import com.cenfotec.graphqlExamen.domain.Condominio;
import com.cenfotec.graphqlExamen.domain.Historial;
import com.cenfotec.graphqlExamen.domain.Persona;
import com.cenfotec.graphqlExamen.service.AmenidadService;
import com.cenfotec.graphqlExamen.service.CondominioService;
import com.cenfotec.graphqlExamen.service.HistorialService;
import com.cenfotec.graphqlExamen.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/condominio"})
public class CondominioController {
    @Autowired
    private CondominioService condominioService;

    @Autowired
    private HistorialService historialService;
    @Autowired
    private AmenidadService amenidadService;

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List getAll() {
        return condominioService.getAll();
    }



    @PostMapping
    public Condominio create(@RequestBody Condominio condominio) {

        return condominioService.save(condominio).get();
    }


 /*   @GetMapping(path = {"/listar/{id}"})
    public List<Historial> listarHistorial(Historial historial, @PathVariable long id) {
        Optional<Condominio> condominio = condominioService.findById(id);
        if (condominio.isPresent()) {
            historial.setCuota(condominio.get().getCuotaCondominal());
            //historial.setCondominio(condominio.get());
            historialService.save(historial);
        }
        return historialService.getCondomino(condominio.get());

    }*/

   @PostMapping(value = {"add/{id}"})
    public Condominio agregarAmenidadACondominio(@RequestBody Amenidad amenidad, @PathVariable long id) {
        Optional<Condominio> condominio = condominioService.findById(id);
        if (condominio.isPresent()) {
            amenidadService.save(amenidad);
            condominio.get().getListaAmenidad().add(amenidad);
           condominioService.save(condominio.get());
        }
        return condominio.get();

    }

    @PostMapping(value = {"p/{id}"})
    public Condominio agregarPersonaACondominio(@RequestBody Persona persona, @PathVariable long id) {
        Optional<Condominio> condominio = condominioService.findById(id);
        if (condominio.isPresent()) {
            personaService.save(persona);
            condominio.get().getListaPersona().add(persona);
            condominioService.save(condominio.get());
        }
        return condominio.get();
    }



    @PutMapping(value = "/{id}")
    public ResponseEntity<Condominio> update(@PathVariable("id") long id,
                                             @RequestBody Condominio condominio) {
        Historial historial = new Historial();
        condominio.setId(id);
        Optional<Condominio> result = condominioService.findById(id);
        if (result.get().getEstado().equals(true)) {
            historial.setCuota(result.get().getCuotaCondominal());
            result.get().getHistorial().add(historial);
         //historial.setCondominio(result.get());
            historialService.save(historial);
            System.out.println("estado:  " + result.get().getEstado());
            result = condominioService.update(condominio);
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/{id}/{estado}")
    public ResponseEntity<Condominio> desactivar(@PathVariable("id") long id,
                                                 @RequestBody Condominio condominio) {
        condominio.setId(id);
        Optional<Condominio> result = condominioService.findById(id);
        if (result.get().getEstado().equals(true)) {
            result.get().setEstado(false);
            result = condominioService.desactivar(condominio);
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (condominioService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = {"/{estado}"})
    public List<Condominio> findTrue(@PathVariable Boolean estado) {
        List<Condominio> result = condominioService.findtrue(true);
        if (estado.equals(true)) {
            result = condominioService.findtrue(true);

        } else {
            result = condominioService.findfalse(false);

        }
        return result;
    }


}
