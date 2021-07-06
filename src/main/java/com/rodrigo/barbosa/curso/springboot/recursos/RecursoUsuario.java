package com.rodrigo.barbosa.curso.springboot.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rodrigo.barbosa.curso.springboot.entidades.Usuario;
import com.rodrigo.barbosa.curso.springboot.servicos.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {
	
	@Autowired
	private ServicoUsuario servicoUsuario;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> usuarios = servicoUsuario.buscarTodos();
		return ResponseEntity.ok().body(usuarios);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario usuario = servicoUsuario.buscarPorId(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario usuario){
		usuario = servicoUsuario.inserir(usuario);
		URI uriUsuario = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uriUsuario).body(usuario);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		servicoUsuario.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario){
		usuario = servicoUsuario.atualizar(id, usuario);
		return ResponseEntity.ok().body(usuario);
	}
}
