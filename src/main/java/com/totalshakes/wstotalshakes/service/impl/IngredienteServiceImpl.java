package com.totalshakes.wstotalshakes.service.impl;

import com.totalshakes.wstotalshakes.domain.model.Ingrediente;
import com.totalshakes.wstotalshakes.domain.repository.IngredienteRepository;
import com.totalshakes.wstotalshakes.exception.IngredienteJaCadastrado;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontrado;
import com.totalshakes.wstotalshakes.service.IngredienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IngredienteServiceImpl implements IngredienteService {

    private final IngredienteRepository repository;

    @Override
    public Ingrediente saveIngrediente(Ingrediente ingrediente) throws IngredienteJaCadastrado {
        var ingredienteExiste = repository.findById(ingrediente.getId());
        if (ingredienteExiste.isPresent())
            throw new IngredienteJaCadastrado();
        return repository.save(ingrediente);
    }

    @Override
    public void updateIngrediente(Ingrediente ingrediente) throws IngredienteNaoEncontrado {
        var id = ingrediente.getId();
        repository.save(getIngredienteById(id));
    }

    @Override
    public void deleteIngrediente(int id) throws IngredienteNaoEncontrado {
        repository.delete(getIngredienteById(id));
    }

    @Override
    public Ingrediente getIngrediente(int id) throws IngredienteNaoEncontrado {
        return getIngredienteById(id);
    }

    @Override
    public List<Ingrediente> getAllIngrediente() {
        return repository.findAll();
    }

    private Ingrediente getIngredienteById(int id) throws IngredienteNaoEncontrado {
        var existIngredient = repository.findById(id);
        if (existIngredient.isEmpty())
            throw new IngredienteNaoEncontrado();
        return existIngredient.get();
    }
}
