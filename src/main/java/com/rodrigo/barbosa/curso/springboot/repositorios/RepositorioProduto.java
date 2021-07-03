package com.rodrigo.barbosa.curso.springboot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.barbosa.curso.springboot.entidades.Produto;

public interface RepositorioProduto extends JpaRepository<Produto, Long> {
	
}
