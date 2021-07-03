package com.rodrigo.barbosa.curso.springboot.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.barbosa.curso.springboot.entidades.Pedido;
import com.rodrigo.barbosa.curso.springboot.repositorios.RepositorioPedido;

@Service
public class ServicoPedido {

	@Autowired
	private RepositorioPedido repositorio;
	
	public List<Pedido> buscarTodos(){
		return repositorio.findAll();
	}
	
	public Pedido buscarPorId(Long id) {
		Optional<Pedido> pedido = repositorio.findById(id);
		return pedido.get();
	}
}
