package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Autores;


public interface AutoresDao {
	public int create(Autores autor);

	public int update(Autores autor);

	public int delete(int id);

	public Autores read(int id);

	public List<Autores> readAll();
}
