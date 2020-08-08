package dev.diogoro.softplan.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.diogoro.softplan.BaseTest;
import dev.diogoro.softplan.model.UsuarioDto;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest extends BaseTest {
	private final String CAMINHO_API = "/api/v1/usuario/";

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	void testObterListaUsuarios() throws Exception {
		mockMvc.perform(get(CAMINHO_API)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	@Test
	void testObterUsuarioPorId() throws Exception {
		mockMvc.perform(get(CAMINHO_API + UUID.randomUUID().toString())
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	@Test
	void testCriarUsuario() throws Exception {
		UsuarioDto usuarioDto = obterUsuarioAdmin();
		String usuarioDtoJson = objectMapper.writeValueAsString(usuarioDto);
		System.out.println(usuarioDtoJson);

		mockMvc.perform(post(CAMINHO_API)
				.contentType(MediaType.APPLICATION_JSON)
				.content(usuarioDtoJson)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated());
	}

	@Test
	void testAtualizarUsuarioPorId() throws Exception {
		UsuarioDto usuarioDto = obterUsuarioAdmin();
		String usuarioDtoJson = objectMapper.writeValueAsString(usuarioDto);
		System.out.println(usuarioDtoJson);

		mockMvc.perform(put(CAMINHO_API + UUID.randomUUID().toString())
				.contentType(MediaType.APPLICATION_JSON)
				.content(usuarioDtoJson)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isNoContent());
	}

	@Test
	void testApagarUsuarioPorId() throws Exception {
		mockMvc.perform(delete(CAMINHO_API + UUID.randomUUID().toString()))
		.andExpect(status().isNoContent());
	}

}
