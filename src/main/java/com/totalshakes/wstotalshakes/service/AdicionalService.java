package com.totalshakes.wstotalshakes.service;

import com.totalshakes.wstotalshakes.domain.model.Adicional;

import java.util.List;

public interface AdicionalService {
    void saveAdicional(Adicional adicional) throws IllegalAccessException;

    void updateAdicional(Adicional adicional) throws IllegalAccessException;

    void deleteAdicional(int id) throws IllegalAccessException;

    Adicional getAdicional(int id) throws IllegalAccessException;

    List<Adicional> getAllAdicional();
}
