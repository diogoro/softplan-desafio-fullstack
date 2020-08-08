package dev.diogoro.softplan.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
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
public class UsuarioDto {

	@Null
	private UUID id;
	
	@NotBlank
	private String login;
	
	@NotBlank 
	private String senha;
	
	@NotBlank
	private String nome;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
	@Null
	private OffsetDateTime dataCriacao;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
	@Null
	private OffsetDateTime dataAtualizacao;
	
	
}
