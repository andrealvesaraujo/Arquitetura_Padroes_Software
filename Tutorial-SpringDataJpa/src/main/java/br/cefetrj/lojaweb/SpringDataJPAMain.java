package br.cefetrj.lojaweb;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.cefetrj.lojaweb.domain.Produto;
import br.cefetrj.lojaweb.service.ProdutoService;

/**
 * Simple tester for Spring-Data-JPA.
 **/
public class SpringDataJPAMain {
	public static void main(String[] args) {

		// Create Spring application context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:/spring.xml");

		// Get service from context.
		ProdutoService ProdutoService = ctx.getBean(ProdutoService.class);

		// Add some items
		ProdutoService.add(new Produto(1, "TV"));
		ProdutoService.add(new Produto(2, "Telefone"));
		ProdutoService.addAll(Arrays.asList(
				new Produto(3, "Sofá de 4 lugares"), new Produto(4,
						"Mesa de 4 lugares"), new Produto(5, "Estante"),
				new Produto(6, "Cadeira")));

		// Test entity listing
		System.out.println("findAll=" + ProdutoService.findAll());

		// Test specified find methods
		System.out.println("findByNome is 'Sofá': "
				+ ProdutoService.findByNameIs("Sofá"));
		System.out.println("findByNomeContainingIgnoreCase 'lugares': "
				+ ProdutoService.findByNomeContainingIgnoreCase("lugares"));

		ctx.close();
	}
}