package com.totalshakes.wstotalshakes.exception;

public class IngredienteNaoEncontrado extends Exception{
    private static final String MSG = "Ingrediente não encontrado.";

    public IngredienteNaoEncontrado(){
        super(MSG);
    }

}
