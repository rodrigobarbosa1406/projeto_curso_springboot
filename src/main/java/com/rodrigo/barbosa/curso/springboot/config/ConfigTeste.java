package com.rodrigo.barbosa.curso.springboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rodrigo.barbosa.curso.springboot.entidades.Usuario;
import com.rodrigo.barbosa.curso.springboot.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class ConfigTeste implements CommandLineRunner {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;

	public void run(String... args) throws Exception {

		Usuario usuario1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "11999999999", "123456");
		Usuario usuario2 = new Usuario(null, "Alex Green", "alex@gmail.com", "11999999999", "123456");
		
		repositorioUsuario.saveAll(Arrays.asList(usuario1, usuario2));
	}
}
