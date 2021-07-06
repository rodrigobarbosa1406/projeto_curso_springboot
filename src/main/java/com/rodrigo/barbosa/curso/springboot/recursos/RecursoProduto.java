package com.rodrigo.barbosa.curso.springboot.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.barbosa.curso.springboot.entidades.Produto;
import com.rodrigo.barbosa.curso.springboot.servicos.ServicoProduto;

@RestController
@RequestMapping(value = "/produtos")
public class RecursoProduto {
	
	@Autowired
	private ServicoProduto servicoProduto;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> produtos = servicoProduto.buscarTodos();
		return ResponseEntity.ok().body(produtos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto produto = servicoProduto.buscarPorId(id);
		return ResponseEntity.ok().body(produto);
	}
}
