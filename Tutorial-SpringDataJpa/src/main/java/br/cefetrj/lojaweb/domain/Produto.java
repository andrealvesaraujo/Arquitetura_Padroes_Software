package br.cefetrj.lojaweb.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	public Integer id;
	public String nome;

	public Produto() {
		// Default constructor needed for JPA.
	}

	public Produto(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + "]";
	}

}