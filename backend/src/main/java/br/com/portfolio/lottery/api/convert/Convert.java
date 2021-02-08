package br.com.portfolio.lottery.api.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Convert {

	private ModelMapper mapper;
	
	@Autowired
	public Convert(ModelMapper mapper) {
		this.mapper = mapper;
	}

	public <T, E> E mapper(T source, Class<E> typeDestination) {
		return mapper.map(source, typeDestination);
	}

}
