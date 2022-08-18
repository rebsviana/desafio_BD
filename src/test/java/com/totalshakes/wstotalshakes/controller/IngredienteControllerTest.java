package com.totalshakes.wstotalshakes.controller;

import com.totalshakes.wstotalshakes.domain.model.Ingrediente;
import com.totalshakes.wstotalshakes.exception.IngredienteJaCadastrado;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontrado;
import com.totalshakes.wstotalshakes.service.IngredienteService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@MockitoSettings
class IngredienteControllerTest {

    @Mock
    IngredienteService service;

    @InjectMocks
    IngredienteController controller;

    Ingrediente ingrediente;

    @BeforeEach
    void setup(){
        ingrediente = Ingrediente.builder().id(1).name("Leite").build();
    }

    @Test
    @DisplayName("Salvar ingrediente no banco de dados")
    void shouldSaveIngredient() throws IngredienteJaCadastrado {

        var responseEntity = controller.saveIngrediente(ingrediente);

        verify(service, times (1)).saveIngrediente(ingrediente);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(responseEntity.getBody()).isNull();
    }

    @Test
    @DisplayName("Atualizar ingrediente no banco de dados")
    void shouldUpdateIngredient() throws IngredienteNaoEncontrado {
        // when
        var actual = controller.updateIngrediente(ingrediente);

        //then
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(service, times (1)).updateIngrediente(ingrediente);
        assertThat(actual.getBody()).isNull();
    }

    @Test
    @DisplayName("Deletar ingrediente pelo id no banco de dados")
    void shouldDeleteIngredient() throws IngredienteNaoEncontrado {
        //given

        //when
        var actual = controller.deleteIngrediente(ingrediente.getId());

        //then
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
        verify(service, times(1)).deleteIngrediente(ingrediente.getId());
        assertThat(actual.getBody()).isNull();
    }

    @Test
    @DisplayName("Consultar ingrediente pelo id no banco de dados")
    void shouldReturnIngredient() throws IngredienteNaoEncontrado {
        //given
        when(service.getIngrediente(ingrediente.getId())).thenReturn(ingrediente);

        //when
        var actual = controller.getIngrediente(ingrediente.getId());

        //then
        assertThat(actual.getBody()).isEqualTo(ingrediente);
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    @DisplayName("Consultar todos os ingrediente do banco de dados")
    void shouldReturnAllIngredient(){
        //given
        final var ingrediente1 = Ingrediente.builder().id(1).name("Sorvete").build();
        final var ingrediente2 = Ingrediente.builder().id(2).name("Iorgurte").build();
        final var listIngredient = Arrays.asList(ingrediente1, ingrediente2, ingrediente);

        when(service.getAllIngrediente()).thenReturn(listIngredient);

        //when
        var actual = controller.getAllIngrediente();

        //then
        assertThat(listIngredient.size()).isEqualTo(3);
        assertThat(listIngredient.get(0)).isEqualTo(ingrediente1);
        assertThat(listIngredient.get(1)).isEqualTo(ingrediente2);
        assertThat(listIngredient.get(2)).isEqualTo(ingrediente);
        assertThat(actual.getBody()).isEqualTo(listIngredient);
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}