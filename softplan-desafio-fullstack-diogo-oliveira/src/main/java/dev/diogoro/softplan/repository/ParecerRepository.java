package dev.diogoro.softplan.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.diogoro.softplan.domain.Parecer;

public interface ParecerRepository extends JpaRepository<Parecer, UUID>{

}
