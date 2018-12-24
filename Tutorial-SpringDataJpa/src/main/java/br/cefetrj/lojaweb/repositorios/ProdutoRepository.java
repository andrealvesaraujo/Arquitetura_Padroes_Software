package br.cefetrj.lojaweb.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.cefetrj.lojaweb.domain.Produto;

/**
 * This is the Data Access layer. Simple huh? PLease note that no need for any
 * dao implementation. This is an interface!
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	/**
	 * No need to define findAll() here, because inherited from JpaRepository
	 * with many other basic JPA operations.
	 **/
	// public List<Product> findAll();

	/**
	 * spring-jpa-data understands this method name, because it supports the
	 * resolution of specific keywords inside method names.
	 **/
	public List<Produto> findByNomeContainingIgnoreCase(String searchString);

	/** You can define a JPA query. **/
	@Query("select p from Produto p where p.nome = :nome")
	public List<Produto> findByNomeIs(@Param("nome") String nome);

}