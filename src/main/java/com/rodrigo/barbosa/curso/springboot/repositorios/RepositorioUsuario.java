package com.rodrigo.barbosa.curso.springboot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.barbosa.curso.springboot.entidades.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
	
}
