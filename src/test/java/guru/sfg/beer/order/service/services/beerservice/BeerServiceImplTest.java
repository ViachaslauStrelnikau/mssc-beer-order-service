package guru.sfg.beer.order.service.services.beerservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BeerServiceImplTest {

    @Autowired
    private BeerServiceImpl beerService;

    @Test
    void getBeerInfoByUpc() {
        BeerDto beerDto =beerService.getBeerByUpc("0631234200036");
        System.out.println(beerDto);
    }
}