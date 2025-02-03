package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.services.beerservice.BeerDto;
import guru.sfg.beer.order.service.services.beerservice.BeerService;
import guru.sfg.brewery.model.BeerOrderLineDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(uses = {DateMapper.class})
public abstract class BeerOrderLineMapper {
    @Autowired
    private BeerService beerService;

    abstract BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

    @AfterMapping
    protected void fetchBeerDetails(BeerOrderLine line, @MappingTarget BeerOrderLineDto dto){
        BeerDto beerDto =beerService.getBeerByUpc(line.getUpc());

        if (beerDto!=null) {
            dto.setUpc(beerDto.getUpc());
            dto.setBeerName(beerDto.getBeerName());
            dto.setBeerId(beerDto.getId());
            dto.setPrice(beerDto.getPrice());
        }
    }

    abstract BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto);
}
