package dev.diogoro.softplan.mapper;

import org.mapstruct.Mapper;

import dev.diogoro.softplan.domain.Processo;
import dev.diogoro.softplan.model.ProcessoDto;


@Mapper(uses = DateMapper.class)
public interface ProcessoMapper {

	Processo processoDtoParaProcesso(ProcessoDto processoDto);
	
	ProcessoDto processoParaProcessoDto(Processo processo);
}
