package com.rodrigo.barbosa.curso.springboot.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.barbosa.curso.springboot.entidades.Produto;
import com.rodrigo.barbosa.curso.springboot.repositorios.RepositorioProduto;

@Service
public class ServicoProduto {

	@Autowired
	private RepositorioProduto repositorio;
	
	public List<Produto> buscarTodos(){
		return repositorio.findAll();
	}
	
	public Produto buscarPorId(Long id) {
		Optional<Produto> produto = repositorio.findById(id);
		return produto.get();
	}
}
