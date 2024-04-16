package com.JDBC.carro.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidaPlacaTest {

    @Test
    void testPlacaAntiga() {
        assertTrue(ValidaPlaca.setPlacaAntiga("ABC-1234"));
        assertFalse(ValidaPlaca.setPlacaNova("ABC-123456"));
    }

    @Test
    void testPlacaNova() {
        assertTrue(ValidaPlaca.setPlacaNova("ABC1D23"));
        assertFalse(ValidaPlaca.setPlacaNova("ABCDD23")); //placa incorreta, deve passar pois esta assertFalse
    }

    @Test
    void testValida() {
        assertTrue(ValidaPlaca.valida("ABC-1234"));
        assertTrue(ValidaPlaca.valida("ABC1D23"));
        assertFalse(ValidaPlaca.valida("ABCDD23")); //placa incorreta, deve passar pois esta assertFalse
    }
}
