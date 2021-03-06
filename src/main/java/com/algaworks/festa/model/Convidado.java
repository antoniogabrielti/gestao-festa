package com.algaworks.festa.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Convidado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")

	private Long id;
	private String nome;
	private int acompanhantes;

	
	public Convidado() {
	}

	public Convidado(Long id, String nome,int acompanhantes) {
		this.id = id;
		this.nome = nome;
		this.acompanhantes = acompanhantes;
	}

	public Convidado(String nome,int acompanhantes) {
		this.nome = nome;
		this.acompanhantes = acompanhantes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAcompanhantes() {
		return acompanhantes;
	}

	public void setAcompanhantes(int acompanhantes) {
		this.acompanhantes = acompanhantes;
	}
}
