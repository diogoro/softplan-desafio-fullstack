package dev.diogoro.softplan;

import java.util.ArrayList;
import java.util.List;

import dev.diogoro.softplan.model.UsuarioDto;

public class BaseTest {

	
	public UsuarioDto obterUsuarioAdmin() {
		return UsuarioDto.builder()
				.login("admin")
				.senha("admin")
				.nome("Usuario admin")
				.build();
	}
	
	public UsuarioDto obterUsuarioTriador() {
		return UsuarioDto.builder()
				.login("triador")
				.senha("triador")
				.nome("Usuario triador")
				.build();
	}
	
	public UsuarioDto obterUsuarioFinalizador() {
		return UsuarioDto.builder()
				.login("finalizador")
				.senha("finalizador")
				.nome("Usuario finalizador")
				.build();
	}
	
	public List<UsuarioDto> obterListaUsuarios() {
		List<UsuarioDto> lista = new ArrayList<>();
		lista.add(obterUsuarioAdmin());
		lista.add(obterUsuarioTriador());
		lista.add(obterUsuarioFinalizador());
		return lista;
	}
}
