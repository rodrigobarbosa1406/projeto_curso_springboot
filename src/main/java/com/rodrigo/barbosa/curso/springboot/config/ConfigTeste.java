package com.rodrigo.barbosa.curso.springboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rodrigo.barbosa.curso.springboot.entidades.Categoria;
import com.rodrigo.barbosa.curso.springboot.entidades.Pedido;
import com.rodrigo.barbosa.curso.springboot.entidades.Produto;
import com.rodrigo.barbosa.curso.springboot.entidades.Usuario;
import com.rodrigo.barbosa.curso.springboot.entidades.enums.StatusPedido;
import com.rodrigo.barbosa.curso.springboot.repositorios.RepositorioCategoria;
import com.rodrigo.barbosa.curso.springboot.repositorios.RepositorioPedido;
import com.rodrigo.barbosa.curso.springboot.repositorios.RepositorioProduto;
import com.rodrigo.barbosa.curso.springboot.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class ConfigTeste implements CommandLineRunner {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private RepositorioPedido repositorioPedido;
	
	@Autowired
	private RepositorioCategoria repositorioCategoria;
	
	@Autowired
	private RepositorioProduto repositorioProduto;

	public void run(String... args) throws Exception {

		Usuario usuario1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "11999999999", "123456");
		Usuario usuario2 = new Usuario(null, "Alex Green", "alex@gmail.com", "11999999999", "123456");
		repositorioUsuario.saveAll(Arrays.asList(usuario1, usuario2));
		
		Pedido pedido1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.PAGO, usuario1);
		Pedido pedido2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.AGUARDANDO_PAGAMENTO, usuario2);
		Pedido pedido3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusPedido.AGUARDANDO_PAGAMENTO, usuario1);
		repositorioPedido.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
		
		Categoria categoria1 = new Categoria(null, "Eletrônicos");
		Categoria categoria2 = new Categoria(null, "Livros");
		Categoria categoria3 = new Categoria(null, "Computadores");
		repositorioCategoria.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
		
		Produto produto1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto produto2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto produto3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto produto4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto produto5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		repositorioProduto.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
		
		produto1.getCategorias().add(categoria2);
		produto2.getCategorias().add(categoria1);
		produto2.getCategorias().add(categoria3);
		produto3.getCategorias().add(categoria3);
		produto4.getCategorias().add(categoria3);
		produto5.getCategorias().add(categoria2);
		repositorioProduto.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
	}
}
