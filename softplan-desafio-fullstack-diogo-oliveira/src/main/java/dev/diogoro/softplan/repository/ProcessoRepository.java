package dev.diogoro.softplan.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.diogoro.softplan.domain.Processo;

public interface ProcessoRepository extends JpaRepository<Processo, UUID>{

}
