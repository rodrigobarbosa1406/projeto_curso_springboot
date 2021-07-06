package com.rodrigo.barbosa.curso.springboot.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.barbosa.curso.springboot.entidades.Pedido;
import com.rodrigo.barbosa.curso.springboot.servicos.ServicoPedido;

@RestController
@RequestMapping(value = "/pedidos")
public class RecursoPedido {
	
	@Autowired
	private ServicoPedido servicoPedido;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll(){
		List<Pedido> pedidos = servicoPedido.buscarTodos();
		return ResponseEntity.ok().body(pedidos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id){
		Pedido pedido = servicoPedido.buscarPorId(id);
		return ResponseEntity.ok().body(pedido);
	}
}
