package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AutoresDao;
import com.example.demo.entity.Autores;
import com.example.demo.service.AutoresService;

@Service
public class AutoresServiceImpl implements AutoresService {
	@Autowired
	private AutoresDao dao;

	@Override
	public int create(Autores autor) {
		return dao.create(autor);
	}

	@Override
	public int update(Autores autor) {
		return dao.update(autor);
	}

	@Override
	public int delete(int id) {
		return dao.delete(id);
	}

	@Override
	public Autores read(int id) {
		return dao.read(id);
	}

	@Override
	public List<Autores> readAll() {
		return dao.readAll();

	}
}
