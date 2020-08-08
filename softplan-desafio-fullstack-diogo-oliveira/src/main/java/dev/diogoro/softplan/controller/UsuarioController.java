package dev.diogoro.softplan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.diogoro.softplan.model.UsuarioDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

	@GetMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<UsuarioDto> obterListaUsuarios() {
		log.debug("Iniciando o obterListaUsuarios");
		List<UsuarioDto> lista = new ArrayList<>();
		return lista;
	}

	@GetMapping("/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public UsuarioDto obterUsuarioPorId(@PathVariable("id") UUID id) {
		log.debug("Iniciando o obterUsuarioPorId");
		log.debug("Parametro: " + id);
		return UsuarioDto.builder().build();
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioDto criarUsuario(@RequestBody @Validated UsuarioDto usuario) {
		log.debug("Iniciando o criarUsuario");
		log.debug("Parametro: " + usuario);
		return UsuarioDto.builder().build();
	}

	@PutMapping("/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public UsuarioDto atualizarUsuarioPorId(@PathVariable("id") UUID id, @RequestBody @Validated UsuarioDto usuario) {
		log.debug("Iniciando o atualizarUsuarioPorId");
		log.debug("Parametros -> id: "+ id + " usuarioDto: "+ usuario);
		return UsuarioDto.builder().build();
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarUsuarioPorId(@PathVariable("id") UUID id) {
		log.debug("Iniciando o apagarUsuarioPorId");
		log.debug("Parametro: " + id);
	}
}
