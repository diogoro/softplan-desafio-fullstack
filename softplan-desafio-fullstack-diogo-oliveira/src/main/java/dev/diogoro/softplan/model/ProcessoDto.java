package dev.diogoro.softplan.model;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessoDto {

	@Null
	private UUID id;
	@NotBlank
	private String descricao;
	
	@NotNull
	private UsuarioDto usuarioCadastro;
	
	@NotNull
	@Singular("listaUsuariosParecer")
	private Set<UsuarioDto> listaUsuariosParecer;
	
	@Singular("pareceres")
	private Set<ParecerDto> pareceres;
	
	@Null
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private OffsetDateTime dataCriacao;
	
	@Null
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private OffsetDateTime dataAtualizacao;
	
	
}
