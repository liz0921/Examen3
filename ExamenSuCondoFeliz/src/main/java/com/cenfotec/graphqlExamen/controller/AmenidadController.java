package com.cenfotec.graphqlExamen.controller;
import com.cenfotec.graphqlExamen.domain.Amenidad;
import com.cenfotec.graphqlExamen.service.AmenidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping({"/amenidad"})
public class AmenidadController {

    @Autowired
    private AmenidadService amenidadService;

    @PostMapping
    public Amenidad createAmenidad(@RequestBody Amenidad amenidad) {
        return amenidadService.save(amenidad).get();
    }

    @GetMapping
    public List getAll() {
        return amenidadService.getAll();
    }


}