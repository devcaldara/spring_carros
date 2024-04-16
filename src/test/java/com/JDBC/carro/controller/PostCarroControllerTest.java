package com.JDBC.carro.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.JDBC.carro.model.Carro;
import com.JDBC.carro.repository.CarroRepository;

public class PostCarroControllerTest {
    private CarroController carroController;
    private CarroRepository carroRepository;

    @BeforeEach
    public void setUp() {
        carroRepository = mock(CarroRepository.class);
        carroController = new CarroController(carroRepository);
    }

    @Test
    public void testCadastrarCarroValido() {
        String nome = "Nome do Carro";
        String fabricante = "Fabricante";
        String placa = "ABC-1234"; // Exemplo de placa válida
        String expectedView = "redirect:/carros";

        String result = carroController.cadastrarCarro(nome, fabricante, placa);
        
         assertTrue(result.equals(expectedView));
         //Verifica se o método save do carroRepository foi chamado exatamente uma vez durante o teste,
         //com qualquer instância de Carro como argumento.
         verify(carroRepository, times(1)).save(any(Carro.class));
    }

    @Test
    public void testCadastrarCarroInvalido() {
        String nome = ""; // Nome inválido
        String fabricante = "Fabricante";
        String placa = "123456"; // Placa inválida
        String expectedView = "carro-erro";

        String result = carroController.cadastrarCarro(nome, fabricante, placa);

        assertTrue(result.equals(expectedView));
        //verifica se o método save do carroRepository nunca foi chamado durante o teste,
        //com qualquer instância de Carro como argumento. Se o método save for chamado pelo menos uma vez, o teste falhará.
        verify(carroRepository, never()).save(any(Carro.class));
    }
}
