package com.rodrigo.barbosa.curso.springboot.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.barbosa.curso.springboot.entidades.Usuario;
import com.rodrigo.barbosa.curso.springboot.servicos.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {
	
	@Autowired
	private ServicoUsuario servico;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> usuarios = servico.buscarTodos();
		return ResponseEntity.ok().body(usuarios);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario usuario = servico.buscarPorId(id);
		return ResponseEntity.ok().body(usuario);
	}
}
