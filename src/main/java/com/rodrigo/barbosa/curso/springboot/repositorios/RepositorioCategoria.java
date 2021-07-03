package com.rodrigo.barbosa.curso.springboot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.barbosa.curso.springboot.entidades.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {
	
}
