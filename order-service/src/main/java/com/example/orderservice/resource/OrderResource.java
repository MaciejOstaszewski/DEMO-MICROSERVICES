package com.example.orderservice.resource;


import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.Objects.nonNull;

@Slf4j
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderResource {


    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAll() {
        log.debug("Rest request for all orders");
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long id) {
        log.debug("Rest request for get order by id [{}]", id);
        if (nonNull(orderService.getOrder(id))) {
            return ResponseEntity.ok(orderService.getOrder(id));
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @PostMapping
    public ResponseEntity<OrderDTO> saveOrder(@Valid @RequestBody OrderDTO orderDTO) {
        return new ResponseEntity<OrderDTO>(orderService.saveOrder(orderDTO), HttpStatus.CREATED);
    }

}
