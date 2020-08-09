package dev.diogoro.softplan.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.diogoro.softplan.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

}
