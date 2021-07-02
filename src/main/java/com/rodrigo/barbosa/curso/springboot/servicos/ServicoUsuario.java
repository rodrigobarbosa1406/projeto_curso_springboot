package com.rodrigo.barbosa.curso.springboot.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.barbosa.curso.springboot.entidades.Usuario;
import com.rodrigo.barbosa.curso.springboot.repositorios.RepositorioUsuario;

@Service
public class ServicoUsuario {

	@Autowired
	private RepositorioUsuario repositorio;
	
	public List<Usuario> buscarTodos(){
		return repositorio.findAll();
	}
	
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> usuario = repositorio.findById(id);
		return usuario.get();
	}
}
