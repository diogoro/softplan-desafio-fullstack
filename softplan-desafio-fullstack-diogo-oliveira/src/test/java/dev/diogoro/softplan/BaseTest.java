package dev.diogoro.softplan;

import java.util.ArrayList;
import java.util.List;

import dev.diogoro.softplan.model.ParecerDto;
import dev.diogoro.softplan.model.ProcessoDto;
import dev.diogoro.softplan.model.UsuarioDto;
import dev.diogoro.softplan.util.Perfil;

public class BaseTest {

	
	public UsuarioDto obterUsuarioAdmin() {
		UsuarioDto usuario = UsuarioDto.builder()
				.login("admin")
				.senha("admin")
				.nome("Usuario admin")
				.perfis(Perfil.ADMIN)
				.build();
		
		return usuario;
	}
	
	public UsuarioDto obterUsuarioTriador() {
		UsuarioDto usuario = UsuarioDto.builder()
				.login("triador")
				.senha("triador")
				.nome("Usuario triador")
				.perfis(Perfil.TRIADOR)
				.build();
		return usuario;
	}
	
	public UsuarioDto obterUsuarioFinalizador() {
		UsuarioDto usuario = UsuarioDto.builder()
				.login("finalizador")
				.senha("finalizador")
				.nome("Usuario finalizador")
				.perfis(Perfil.FINALIZADOR)
				.build();
		return usuario;
	}
	
	public List<UsuarioDto> obterListaUsuarios() {
		List<UsuarioDto> lista = new ArrayList<>();
		lista.add(obterUsuarioAdmin());
		lista.add(obterUsuarioTriador());
		lista.add(obterUsuarioFinalizador());
		return lista;
	}
	
	public ProcessoDto obterProcessoValidoUmParecer() {
		return ProcessoDto.builder()
				.descricao("Processo para Testes Unitarios")
				.usuarioCadastro(obterUsuarioTriador())
				.listaUsuariosParecer(obterUsuarioFinalizador())
				.build();
	}
	
	public ParecerDto obterParecerValido() {
		return ParecerDto.builder()
				.descricao("Segue parecer sobre o processo para Testes Unitarios")
				.processo(obterProcessoValidoUmParecer())
				.usuario(obterUsuarioFinalizador())
				.build();
	}
}
