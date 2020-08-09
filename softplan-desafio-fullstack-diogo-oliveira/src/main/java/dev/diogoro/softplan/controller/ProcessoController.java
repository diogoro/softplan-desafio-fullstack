package dev.diogoro.softplan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.diogoro.softplan.model.ProcessoDto;
import dev.diogoro.softplan.model.UsuarioDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/processo")
public class ProcessoController {

	@GetMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<ProcessoDto> obterListaDeProcessos() {
		log.debug("Iniciando o obterListaDeProcessos");
		List<ProcessoDto> lista = new ArrayList<>();
		return lista;
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ProcessoDto obterProcessoPorId(@PathVariable("id") UUID id) {
		log.debug("Iniciando o obterProcessoPorId");
		log.debug("Parametro id: " + id);
		return ProcessoDto.builder().build();
	}
	
	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public ProcessoDto criarProcesso(@RequestBody @Validated ProcessoDto processoDto) {
		log.debug("Iniciando o obterProcessoPorId");
		log.debug("Parametro processoDto: " + processoDto);
		return ProcessoDto.builder().build();
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarProcessoPorId(@PathVariable("id") UUID id, @RequestBody @Validated ProcessoDto processoDto) {
		log.debug("Iniciando o obterProcessoPorId");
		log.debug("Parametro id: " + id);
		log.debug("Parametro processoDto: " + processoDto);
	}
	
	@PutMapping("/{id}/usuario_parecer")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atribuirUsuarioParecerProcesso(@PathVariable("id") UUID id, @RequestBody @Validated Set<UsuarioDto> usuariosParecer) {
		log.debug("Iniciando o obterProcessoPorId");
		log.debug("Parametro id: " + id);
		log.debug("Parametro usuariosParecer: " + usuariosParecer);
	}
}
