package dev.diogoro.softplan.controller;

import java.util.ArrayList;
import java.util.List;
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

import dev.diogoro.softplan.model.ParecerDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/parecer")
public class ParecerController {

	@GetMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<ParecerDto> obterListasDeParecer() {
		log.debug("Iniciando o obterListasDeParecer");
		return new ArrayList<>();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ParecerDto obterParecerPorId(@PathVariable("id") UUID id) {
		log.debug("Iniciando o obterParecerPorId");
		log.debug("Parametro id: " + id);
		return ParecerDto.builder().build();
	}
	
	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public ParecerDto criarParecer(@RequestBody @Validated ParecerDto parecerDto) {
		log.debug("Iniciando o criarParecer");
		log.debug("Parametro parecerDto: " + parecerDto);
		return parecerDto;
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ParecerDto atualizarParecerPorId(@PathVariable("id") UUID id, @RequestBody @Validated ParecerDto parecerDto) {
		log.debug("Iniciando o atualizarParecerPorId");
		log.debug("Parametro id: " + id);
		log.debug("Parametro parecerDto: " + parecerDto);
		return ParecerDto.builder().build();
	}
}
