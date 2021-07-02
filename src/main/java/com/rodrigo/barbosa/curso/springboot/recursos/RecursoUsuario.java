package com.rodrigo.barbosa.curso.springboot.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.barbosa.curso.springboot.entidades.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {
	
	@GetMapping
	public ResponseEntity<Usuario> buscarTodos(){
		Usuario usuario = new Usuario(1L, "Maria", "maria@gmail.com", "11999999999", "12345");
		return ResponseEntity.ok().body(usuario);
	}
}
