package com.JDBC.carro.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ValidaEntradaTest {

    @Test
    void testSetValidaNome() {
        // Teste para nome não nulo e não vazio
        assertTrue(ValidaEntrada.setValidaNome("Toyota"));

        // Teste para nome nulo
        assertFalse(ValidaEntrada.setValidaNome(null));

        // Teste para nome vazio
        assertFalse(ValidaEntrada.setValidaNome(""));

        // Teste para nome contendo apenas espaços em branco
        assertFalse(ValidaEntrada.setValidaNome("   "));
    }

    @Test
    void testSetValidaFabricante() {
        // Teste para fabricante não nulo e não vazio
        assertTrue(ValidaEntrada.setValidaFabricante("Ford"));

        // Teste para fabricante nulo
        assertFalse(ValidaEntrada.setValidaFabricante(null));

        // Teste para fabricante vazio
        assertFalse(ValidaEntrada.setValidaFabricante(""));

        // Teste para fabricante contendo apenas espaços em branco
        assertFalse(ValidaEntrada.setValidaFabricante("   "));
    }

    @Test
    void testSetValidaEntrada() {
        // Teste para entrada válida (nome e fabricante não nulos e não vazios)
        assertTrue(ValidaEntrada.setValidaEntrada("Toyota", "Ford"));

        // Teste para entrada inválida (nome nulo)
        assertFalse(ValidaEntrada.setValidaEntrada(null, "Ford"));

        // Teste para entrada inválida (fabricante nulo)
        assertFalse(ValidaEntrada.setValidaEntrada("Toyota", null));

        // Teste para entrada inválida (nome vazio e fabricante não vazio)
        assertFalse(ValidaEntrada.setValidaEntrada("", "Ford"));

        // Teste para entrada inválida (nome não vazio e fabricante vazio)
        assertFalse(ValidaEntrada.setValidaEntrada("Toyota", ""));

        // Teste para entrada inválida (nome e fabricante vazios)
        assertFalse(ValidaEntrada.setValidaEntrada("", ""));

        // Teste para entrada inválida (nome e fabricante contendo apenas espaços em
        // branco)
        assertFalse(ValidaEntrada.setValidaEntrada("   ", "   "));
    }
}
