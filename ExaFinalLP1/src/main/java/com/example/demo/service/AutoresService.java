package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Autores;


public interface AutoresService {
	public int create(Autores autor);
    public int update(Autores autor);
    public int delete(int id);
    public Autores read(int id);
    public List<Autores> readAll();
}
