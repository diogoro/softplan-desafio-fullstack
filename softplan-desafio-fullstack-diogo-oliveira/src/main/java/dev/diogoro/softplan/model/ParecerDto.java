package dev.diogoro.softplan.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParecerDto {
	
	@Null
	private UUID id;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private UsuarioDto usuario;
	
	@NotNull
	private ProcessoDto processo;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private OffsetDateTime dataCriacao;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private OffsetDateTime dataAtualizacao;

}
