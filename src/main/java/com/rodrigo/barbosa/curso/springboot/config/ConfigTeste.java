package com.rodrigo.barbosa.curso.springboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rodrigo.barbosa.curso.springboot.entidades.Pedido;
import com.rodrigo.barbosa.curso.springboot.entidades.Usuario;
import com.rodrigo.barbosa.curso.springboot.entidades.enums.StatusPedido;
import com.rodrigo.barbosa.curso.springboot.repositorios.RepositorioPedido;
import com.rodrigo.barbosa.curso.springboot.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class ConfigTeste implements CommandLineRunner {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private RepositorioPedido repositorioPedido;

	public void run(String... args) throws Exception {

		Usuario usuario1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "11999999999", "123456");
		Usuario usuario2 = new Usuario(null, "Alex Green", "alex@gmail.com", "11999999999", "123456");
		repositorioUsuario.saveAll(Arrays.asList(usuario1, usuario2));
		
		Pedido pedido1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.PAGO, usuario1);
		Pedido pedido2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.AGUARDANDO_PAGAMENTO, usuario2);
		Pedido pedido3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusPedido.AGUARDANDO_PAGAMENTO, usuario1);
		repositorioPedido.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
	}
}
