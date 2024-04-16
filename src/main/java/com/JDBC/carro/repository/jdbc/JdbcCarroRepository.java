package com.JDBC.carro.repository.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.JDBC.carro.model.Carro;
import com.JDBC.carro.repository.CarroRepository;

import java.util.List;

@Repository
public class JdbcCarroRepository implements CarroRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCarroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Carro> findAll() {
        String sql = "SELECT * FROM carro";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Carro carro = new Carro(rs.getLong("id"), rs.getString("nome"), rs.getString("fabricante"),
                    rs.getString("placa"), rs.getTimestamp("dataEntrada"));
            return carro;
        });
    }

    @Override
    public Carro findById(Long id) {
        String sql = "SELECT * FROM carro WHERE id = ?";
        Carro carro = jdbcTemplate.queryForObject(sql, new Object[]{id}, new CarroRowMapper());
        return carro;

    }

    @Override
    public void save(Carro carro) {
        String sql = "INSERT INTO carro (nome, fabricante, placa) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, carro.getNome(), carro.getFabricante(), carro.getPlaca());
    }

    @Override
    public void update(Long id, Carro carro) {
        String sql = "UPDATE carro SET nome = ?, fabricante = ?, placa = ? WHERE id = ?";
        jdbcTemplate.update(sql, carro.getNome(), carro.getFabricante(), carro.getPlaca(), id);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM carro WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
