package com.JDBC.carro.repository;
import java.util.List;

import com.JDBC.carro.model.Carro;

public interface CarroRepository {
    List<Carro> findAll();
    Carro findById(Long id);
    void save(Carro carro);
    void update(Long id, Carro carro);
    void delete(Long id);
    
}
