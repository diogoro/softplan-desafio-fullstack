package dev.diogoro.softplan.controller;

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
import dev.diogoro.softplan.model.ParecerDto;

@WebMvcTest(ParecerController.class)
class ParecerControllerTest extends BaseTest {

	private final String CAMINHO_API = "/api/v1/parecer/";
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	void testObterListasDeParecer() throws Exception {
		mockMvc.perform(get(CAMINHO_API)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	@Test
	void testObterParecerPorId() throws Exception {
		mockMvc.perform(get(CAMINHO_API + UUID.randomUUID().toString())
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	@Test
	void testCriarParecer() throws Exception {
		ParecerDto parecerDto = obterParecerValido();
		String parecerDtoString = objectMapper.writeValueAsString(parecerDto);
		System.out.println(parecerDtoString);
		
		mockMvc.perform(post(CAMINHO_API)
				.contentType(MediaType.APPLICATION_JSON)
				.content(parecerDtoString)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated());
	}

	@Test
	void testAtualizarParecerPorId() throws Exception {
		ParecerDto parecerDto = obterParecerValido();
		String parecerDtoString = objectMapper.writeValueAsString(parecerDto);
		System.out.println(parecerDtoString);
		
		mockMvc.perform(put(CAMINHO_API + UUID.randomUUID().toString())
				.contentType(MediaType.APPLICATION_JSON)
				.content(parecerDtoString)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isNoContent());
	}

}
