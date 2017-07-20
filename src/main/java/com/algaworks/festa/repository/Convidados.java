package com.algaworks.festa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.algaworks.festa.model.Convidado;


public interface Convidados extends CrudRepository<Convidado, Long> {
	public List<Convidado> findByNomeContaining(String nome);
}
/*
 * <dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<scope>runtime</scope>
	</dependency>
 * */
