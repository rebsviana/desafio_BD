package com.totalshakes.wstotalshakes.exception;

public class QuantidadeInvalida extends Exception{
    private static final String MSG = "Quantidade inválida.";

    public QuantidadeInvalida(){
        super(MSG);
    }
}
