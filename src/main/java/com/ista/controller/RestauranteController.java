package com.ista.controller;

import java.util.List;

import com.ista.model.Restaurante;
import com.ista.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ComponentScan
@RestController
@RequestMapping("/api/restaurante")
public class RestauranteController {
	
	@Autowired
	RestauranteService restauranteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Restaurante>> listarRestaurante() {
        return new ResponseEntity<>(restauranteService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Restaurante> crearRestaurante(@RequestBody Restaurante d) {
        return new ResponseEntity<>(restauranteService.save(d), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Restaurante> actualizarRestaurante(@PathVariable Long id, @RequestBody Restaurante d) {
    	Restaurante resEncontrado = restauranteService.findById(id);
        if (resEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            	resEncontrado.setNombre(d.getNombre());
            	resEncontrado.setTelefono(d.getTelefono());
            	resEncontrado.setCorreo(d.getCorreo());
                return new ResponseEntity<>(restauranteService.save(d), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Restaurante> eliminarRestaurante(@PathVariable Long id) {
    	restauranteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
