package com.totalshakes.wstotalshakes.service.impl;

import com.totalshakes.wstotalshakes.domain.model.Adicional;
import com.totalshakes.wstotalshakes.domain.repository.AdicionalRepository;
import com.totalshakes.wstotalshakes.service.AdicionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AdicionalServiceImpl implements AdicionalService {
    private final AdicionalRepository repository;

    @Override
    public void saveAdicional(Adicional adicional) throws IllegalAccessException {
        var ingredienteExiste = repository.findById(adicional.getId());
        if (ingredienteExiste.isPresent())
            throw new IllegalAccessException();
        repository.save(adicional);
    }

    @Override
    public void updateAdicional(Adicional adicional) throws IllegalAccessException {
        var id = adicional.getId();
        repository.save(getAdicionalById(id));
    }

    @Override
    public void deleteAdicional(int id) throws IllegalAccessException {
        repository.delete(getAdicionalById(id));
    }

    @Override
    public Adicional getAdicional(int id) throws IllegalAccessException {
        return getAdicionalById(id);
    }

    @Override
    public List<Adicional> getAllAdicional() {
        return repository.findAll();
    }

    private Adicional getAdicionalById(int id) throws IllegalAccessException {
        var existAdicional = repository.findById(id);
        if (existAdicional.isEmpty())
            throw new IllegalAccessException();
        return existAdicional.get();
    }

}
