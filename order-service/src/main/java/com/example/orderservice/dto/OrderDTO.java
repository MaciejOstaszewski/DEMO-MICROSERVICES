package com.example.orderservice.dto;

import com.example.orderservice.mapper.ViewModel;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class OrderDTO implements ViewModel {

    private Long id;
    private Long userId;
    private String product;
    private BigDecimal price;
    private Long quantity;
    private UserDTO user;
}
