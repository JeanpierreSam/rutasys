package com.example.demo.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.dao.AutoresDao;
import com.example.demo.entity.Autores;

@Component
public class AutoresDaoImpl implements AutoresDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(Autores autor) {
        String SQL = "INSERT INTO autores (nombres, apellidos, pais, estado) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(SQL, autor.getNombres(), autor.getApellidos(), autor.getPais(), autor.getEstado());
    }

    @Override
    public int update(Autores autor) {
        String SQL = "UPDATE autores SET nombres = ?, apellidos = ?, pais = ?, estado = ? WHERE idautores = ?";
        return jdbcTemplate.update(SQL, autor.getNombres(), autor.getApellidos(), autor.getPais(), autor.getEstado(), autor.getIdautores());
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM autores WHERE idautores = ?";
        return jdbcTemplate.update(SQL, id);
    }

    @Override
    public Autores read(int id) {
        String SQL = "SELECT * FROM autores WHERE idautores = ?";
        Autores autor = jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Autores.class), id);
        return autor;
    }

    @Override
    public List<Autores> readAll() {
        String SQL = "SELECT * FROM autores";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Autores.class));
    }
}
