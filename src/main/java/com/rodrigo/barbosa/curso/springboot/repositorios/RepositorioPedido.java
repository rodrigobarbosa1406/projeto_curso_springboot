package com.rodrigo.barbosa.curso.springboot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.barbosa.curso.springboot.entidades.Pedido;

public interface RepositorioPedido extends JpaRepository<Pedido, Long> {
	
}
