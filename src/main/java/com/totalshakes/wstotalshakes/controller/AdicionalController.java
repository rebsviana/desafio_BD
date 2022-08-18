package com.totalshakes.wstotalshakes.controller;

import com.totalshakes.wstotalshakes.domain.model.Adicional;
import com.totalshakes.wstotalshakes.domain.model.Ingrediente;
import com.totalshakes.wstotalshakes.exception.IngredienteJaCadastrado;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontrado;
import com.totalshakes.wstotalshakes.service.AdicionalService;
import com.totalshakes.wstotalshakes.service.IngredienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/adicional")
public class AdicionalController {

    final AdicionalService service;

    @GetMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<Adicional> getAdicional(@PathVariable final int id) throws IllegalAccessException {
        var adicional = service.getAdicional(id);
        return ResponseEntity.ok(adicional);
    }

    @GetMapping(path="/all", produces = "application/json")
    public ResponseEntity<List<Adicional>> getAllIngrediente(){
        var listAdicionais = service.getAllAdicional();
        return ResponseEntity.ok(listAdicionais);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Void> saveAdicional(@RequestBody final Adicional adicional) throws IllegalAccessException {
        service.saveAdicional(adicional);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(produces = "application/json")
    public ResponseEntity<Void> updateAdicional(@RequestBody final Adicional adicional) throws IllegalAccessException {
        service.updateAdicional(adicional);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<Void> deleteAdicional(@PathVariable final int id) throws IllegalAccessException {
        service.deleteAdicional(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
