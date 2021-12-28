package dev.mwdesigns.msscbeerservice.web.mappers;

import dev.mwdesigns.msscbeerservice.domain.Beer;
import dev.mwdesigns.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {
    BeerDto BeerToBeerDto(Beer beer);
    Beer BeerDtoToBeer(BeerDto beerDto);

}
