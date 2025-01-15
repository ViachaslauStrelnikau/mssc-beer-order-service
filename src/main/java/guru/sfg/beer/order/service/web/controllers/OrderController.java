package guru.sfg.beer.order.service.web.controllers;

import guru.sfg.beer.order.service.services.BeerOrderService;
import guru.sfg.beer.order.service.web.model.BeerOrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/orders")
@RestController
public class OrderController {
    private final BeerOrderService orderService;

    public OrderController(BeerOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<BeerOrderDto>> getAllOrders(){
        return new ResponseEntity<>(orderService.listAllOrders(), HttpStatus.OK);
    }
}
