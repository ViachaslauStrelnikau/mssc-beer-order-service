package guru.sfg.beer.order.service.services.beerservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {

    private final String FIND_BY_UPC_PATH;
    private final String FIND_BY_ID_PATH;
    private final String BEER_SERVICE_HOST;
    private final RestTemplate restTemplate;

    public BeerServiceImpl(
            @Value("${sfg.brewary.beer-findbyupc-path}") String findByUpcPath,
            @Value("${sfg.brewary.beer-findbyid-path}") String findByIdPath,
            @Value("${sfg.brewary.beer-service-host}") String beerServiceHost,
            RestTemplateBuilder builder) {
        this.BEER_SERVICE_HOST = beerServiceHost;
        this.FIND_BY_ID_PATH=findByIdPath;
        this.FIND_BY_UPC_PATH = findByUpcPath;
        this.restTemplate = builder.build();
    }

    @Override
    public BeerDto getBeerByUpc(String upc) {
        ResponseEntity<BeerDto> responseEntity = restTemplate.exchange(BEER_SERVICE_HOST + FIND_BY_UPC_PATH, HttpMethod.GET, null, BeerDto.class, upc);
        return responseEntity.getBody();
    }

    @Override
    public BeerDto getBeerById(UUID id) {
        ResponseEntity<BeerDto> responseEntity = restTemplate.getForEntity(BEER_SERVICE_HOST + FIND_BY_ID_PATH+id.toString(), BeerDto.class);
        return responseEntity.getBody();
    }
}
