package dev.diogoro.softplan.mapper;

import org.mapstruct.Mapper;

import dev.diogoro.softplan.domain.Parecer;
import dev.diogoro.softplan.model.ParecerDto;

@Mapper(uses = DateMapper.class)
public interface ParecerMapper {

	Parecer parecerDtoParaParecer(ParecerDto parecerDto);
	
	ParecerDto parecerParaParecerDto(Parecer parecer);
}
