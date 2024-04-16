package com.JDBC.carro.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.JDBC.carro.model.Carro;
import com.JDBC.carro.repository.CarroRepository;
import com.JDBC.carro.util.ValidaEntrada;
import com.JDBC.carro.util.ValidaPlaca;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarroController {
    private final CarroRepository carroRepository;

    public CarroController(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @GetMapping("/teste")
    public String teste(){
        return "teste";
    }

    @GetMapping("/carros")
    public String listarCarros(Model model) {
        List<Carro> carros = carroRepository.findAll();
        model.addAttribute("carros", carros);
        return "lista-carros"; // Nome do arquivo HTML/Thymeleaf
    }

    @GetMapping("/carros/{id}")
    public String mostrarCarro(@PathVariable Long id, Model model) {
    Carro carro = carroRepository.findById(id);
    model.addAttribute("carro", carro);
    return "CarroEditar"; // Nome do arquivo HTML/Thymeleaf
    }
 
    @PostMapping("/carros")
    public String cadastrarCarro(@RequestParam("nome") String nome,
            @RequestParam("fabricante") String fabricante,
            @RequestParam("placa") String placa) {
            
            // Boolean valid = ValidaPlaca.valida(placa); //primeiro passar somente com a placa
            Boolean valid = ValidaPlaca.valida(placa) && ValidaEntrada.setValidaEntrada(nome, fabricante);

        if (valid) {
            Carro carro = new Carro(null, nome, fabricante, placa, null);
            carroRepository.save(carro);
            return "redirect:/carros";
        } else {
            return "carro-erro";
        }
    }

    @PostMapping("/carros_editar")
    public String atualizarCarro(@ModelAttribute Carro carro) {
        carroRepository.update(carro.getId(), carro);
        return "redirect:/carros";
    }

    @GetMapping("/carros/deletar/{id}")
    public String deletarCarro(@PathVariable Long id) {
        carroRepository.delete(id);
        return "redirect:/carros";
    }
}
