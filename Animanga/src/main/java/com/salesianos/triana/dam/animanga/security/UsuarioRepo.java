package com.salesianos.triana.dam.animanga.security;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepo {

	private List<Usuario> usuarios;

	public List<Usuario> getUsuarios() {
		return Collections.unmodifiableList(usuarios);
	}

	public Optional<Usuario> findUserByUsername(String username) {
		return usuarios.stream().filter(u -> u.getUsername().equals(username)).findFirst();
	}

	@PostConstruct
	public void init() {
		usuarios = List.of(
				Usuario.builder().username("admin").password("admin").role("ADMIN").nombre("Arturo")
						.apellidos("Céspedes Pedrazas").fechaNacimiento(LocalDate.of(2002, 2, 4)).build(),
				Usuario.builder().username("user").password("user").role("USER").nombre("Usuario ").apellidos("Normal")
						.fechaNacimiento(LocalDate.of(2000, 4, 23)).build()

		);

	}

}
