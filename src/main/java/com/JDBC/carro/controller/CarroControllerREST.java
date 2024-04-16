package com.JDBC.carro.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.JDBC.carro.model.Carro;
import com.JDBC.carro.repository.CarroRepository;

@RestController
// @CrossOrigin(origins = "http://localhost:3000/")
//C:\Users\Sidney\Documents\SENAC\Tecnologia em Análise e Desenvolvimento de Sistemas - ADS\Unidade Curricular\Material\Projeto\React\consumo-api
public class CarroControllerREST {
    private final CarroRepository carroRepository;

    public CarroControllerREST(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @GetMapping("/carrosRest")
    public List<Carro> listarCarros() {
        List<Carro> carros = carroRepository.findAll();
        return carros; // Nome do arquivo HTML/Thymeleaf
    }
}
