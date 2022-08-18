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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ingrediente")
public class IngredienteController {

    final IngredienteService serviceIngrediente;

    final AdicionalService serviceAdicional;

    @PostMapping(produces = "application/json")
    public ResponseEntity<Void> saveIngrediente(@Valid @RequestBody final Ingrediente ingrediente) throws IngredienteJaCadastrado {
         serviceIngrediente.saveIngrediente(ingrediente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(produces = "application/json")
    public ResponseEntity<Void> updateIngrediente(@RequestBody final Ingrediente ingrediente) throws IngredienteNaoEncontrado {
        serviceIngrediente.updateIngrediente(ingrediente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<Void> deleteIngrediente(@PathVariable final int id) throws IngredienteNaoEncontrado {
        serviceIngrediente.deleteIngrediente(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<Ingrediente> getIngrediente(@PathVariable final int id) throws IngredienteNaoEncontrado {
        var ingrediente = serviceIngrediente.getIngrediente(id);
        return ResponseEntity.ok(ingrediente);
    }

    @GetMapping(path="/all", produces = "application/json")
    public ResponseEntity<List<Ingrediente>> getAllIngrediente(){
        var listIngrediente = serviceIngrediente.getAllIngrediente();
        return ResponseEntity.ok(listIngrediente);
    }

    @PostMapping("/{id}/adicionais")
    public ResponseEntity<Void> createAdicionalByIngrediente(@PathVariable int id, @RequestBody Adicional adicional) throws IngredienteNaoEncontrado, IngredienteJaCadastrado, IllegalAccessException {

        var ingrediente = serviceIngrediente.getIngrediente(id);

        adicional.setIngrediente(ingrediente);
        serviceAdicional.saveAdicional(adicional);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
