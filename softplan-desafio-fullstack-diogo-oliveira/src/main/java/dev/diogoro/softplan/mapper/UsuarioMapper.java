package dev.diogoro.softplan.mapper;

import org.mapstruct.Mapper;

import dev.diogoro.softplan.domain.Usuario;
import dev.diogoro.softplan.model.UsuarioDto;

@Mapper(uses = DateMapper.class)
public interface UsuarioMapper {
	Usuario usuarioDtoParaUsuario(UsuarioDto usuarioDto);
	
	UsuarioDto usuarioParaUsuarioDto(Usuario usuario);
}
