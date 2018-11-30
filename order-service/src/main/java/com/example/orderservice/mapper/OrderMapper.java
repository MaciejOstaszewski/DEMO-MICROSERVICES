package com.example.orderservice.mapper;

import com.example.orderservice.domain.Order;
import com.example.orderservice.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapper implements Mapper<Order, OrderDTO> {

    private final ModelMapper modelMapper;

    @Override
    public Order toEntity(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, Order.class);
    }

    @Override
    public OrderDTO toDto(Order entity) {
        return modelMapper.map(entity, OrderDTO.class);
    }
}
