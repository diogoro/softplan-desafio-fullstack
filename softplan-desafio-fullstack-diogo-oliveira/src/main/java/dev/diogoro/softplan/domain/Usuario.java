package dev.diogoro.softplan.domain;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import dev.diogoro.softplan.util.Perfil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type="org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID id;
	
	@Column(unique = true)
	private String login;
	
	@NotBlank
	private String senha;
	
	@NotBlank
	private String nome;
	
	@NotNull
	@ElementCollection(fetch = FetchType.EAGER, targetClass = Perfil.class)
	@Enumerated(EnumType.STRING)
	private Set<Perfil> perfis;
	
	@OneToMany
	private Set<Processo> processosCriado;
	
	@OneToMany
	private Set<Parecer> pareceres;
		
	@CreationTimestamp
	@Column(updatable = false)
	private OffsetDateTime dataCriacao;
	
	@UpdateTimestamp
	private OffsetDateTime dataAtualizacao;
}
