package com.totalshakes.wstotalshakes.service.impl;

import com.totalshakes.wstotalshakes.domain.model.Ingrediente;
import com.totalshakes.wstotalshakes.domain.repository.IngredienteRepository;
import com.totalshakes.wstotalshakes.exception.IngredienteJaCadastrado;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontrado;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Optional;

import static org.mockito.Mockito.*;

@MockitoSettings
class IngredienteServiceImplTest {

    @Mock
    private IngredienteRepository repository;

    @InjectMocks
    private IngredienteServiceImpl service;

    @Test
    @DisplayName("Salvar ingrediente")
    void shouldSaveIngredient() throws IngredienteJaCadastrado {
        // given
        final Ingrediente ingrediente = Ingrediente
                .builder().id(1).name("Leite").build();
//        when(repository.save(ingrediente)).thenReturn(true);

        //when
        service.saveIngrediente(ingrediente);

        //then
//        verify(repository, never()).save(ingrediente);
        verify(repository, times(1)).save(ingrediente);
    }

    @Test
    void updateIngrediente() throws IngredienteNaoEncontrado {
        //given
        final Ingrediente ingredienteActual = Ingrediente.builder().id(1).name("Leite").build();
        final Ingrediente ingredienteUpdate = Ingrediente.builder().id(1).name("Iogurte").build();
        repository.save(ingredienteActual);
        when(repository.findById(ingredienteUpdate.getId())).thenReturn(Optional.of(ingredienteActual));

        //when
        service.updateIngrediente(ingredienteUpdate);

        //then
//        verify(service, times(1)).updateIngrediente(ingredienteUpdate);
        verify(repository, times(1)).findById(ingredienteUpdate.getId());
    }

    //TODO: implement test
    @Test
    void deleteIngrediente() {
    }

    @Test
    void getIngrediente() {
    }
}