package dev.diogoro.softplan.model;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonFormat;

import dev.diogoro.softplan.util.Perfil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

	@Null
	private UUID id;

	@NotBlank
	private String login;

	@NotBlank
	private String senha;

	@NotBlank
	private String nome;
	
	@NotNull
	private Set<Perfil> perfis;

	private Set<ProcessoDto> processosCriados;

	private Set<ParecerDto> pareceres;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
	@Null
	private OffsetDateTime dataCriacao;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
	@Null
	private OffsetDateTime dataAtualizacao;
	
	public void adicionarPerfil(Perfil perfil) {
		this.perfis.add(perfil);
	}

}
