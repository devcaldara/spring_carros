package com.JDBC.carro.util;

public abstract class ValidaEntrada {

    public static Boolean setValidaNome(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }
    public static Boolean setValidaFabricante(String fabricante) {
        return fabricante != null && !fabricante.trim().isEmpty();
    }
    public static Boolean setValidaEntrada(String nome, String fabricante) {
        return setValidaNome(nome) && setValidaFabricante(fabricante);
    }
}
