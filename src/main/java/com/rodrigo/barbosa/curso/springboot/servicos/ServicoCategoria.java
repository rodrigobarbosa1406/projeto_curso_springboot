package com.rodrigo.barbosa.curso.springboot.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.barbosa.curso.springboot.entidades.Categoria;
import com.rodrigo.barbosa.curso.springboot.repositorios.RepositorioCategoria;

@Service
public class ServicoCategoria {

	@Autowired
	private RepositorioCategoria repositorio;
	
	public List<Categoria> buscarTodos(){
		return repositorio.findAll();
	}
	
	public Categoria buscarPorId(Long id) {
		Optional<Categoria> categoria = repositorio.findById(id);
		return categoria.get();
	}
}
