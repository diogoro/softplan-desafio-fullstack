package dev.diogoro.softplan.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.diogoro.softplan.BaseTest;
import dev.diogoro.softplan.model.ProcessoDto;
import dev.diogoro.softplan.model.UsuarioDto;

@WebMvcTest(ProcessoController.class)
class ProcessoControllerTest extends BaseTest{
	
	private final String CAMINHO_API = "/api/v1/processo/";
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;

	@Test
	void testObterListaDeProcessos() throws Exception {
		mockMvc.perform(get(CAMINHO_API)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	@Test
	void testObterProcessoPorId() throws Exception {
		mockMvc.perform(get(CAMINHO_API + UUID.randomUUID().toString())
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	@Test
	void testCriarProcesso() throws Exception {
		ProcessoDto processoDto = obterProcessoValidoUmParecer();
		String processoDtoString = objectMapper.writeValueAsString(processoDto);
		System.out.println(processoDtoString);
		
		mockMvc.perform(post(CAMINHO_API)
				.contentType(MediaType.APPLICATION_JSON)
				.content(processoDtoString)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated());
	}

	@Test
	void testAtualizarProcessoPorId() throws Exception {
		ProcessoDto processoDto = obterProcessoValidoUmParecer();
		String processoDtoString = objectMapper.writeValueAsString(processoDto);
		System.out.println(processoDtoString);
		
		mockMvc.perform(put(CAMINHO_API + UUID.randomUUID().toString())
				.contentType(MediaType.APPLICATION_JSON)
				.content(processoDtoString)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isNoContent());
	}

	@Test
	void testAtribuirUsuarioParecerProcesso() throws Exception {
		UsuarioDto usuarioParecer = obterUsuarioFinalizador();
		Set<UsuarioDto> usuariosParecer = new HashSet<UsuarioDto>();
		usuariosParecer.add(usuarioParecer);
		String usuarioParecerJson = objectMapper.writeValueAsString(usuariosParecer);
		System.out.println("Iniciando testAtribuirUsuarioParecerProcesso");
		System.out.println(usuarioParecerJson);
		mockMvc.perform(put(CAMINHO_API + UUID.randomUUID().toString() + "/usuario_parecer")
				.contentType(MediaType.APPLICATION_JSON)
				.content(usuarioParecerJson)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isNoContent());
	}

}
