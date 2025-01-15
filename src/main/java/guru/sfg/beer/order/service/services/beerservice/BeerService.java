package guru.sfg.beer.order.service.services.beerservice;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerByUpc(String upc);
    BeerDto getBeerById(UUID id);

}
