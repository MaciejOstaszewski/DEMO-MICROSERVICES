package com.example.orderservice.service;

import com.example.orderservice.domain.Order;
import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.dto.UserDTO;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final UserResourceClient userResourceClient;

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderDTO> getAll() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.toDtos(orders);
    }

    public OrderDTO getOrder(Long id) {
        Optional<OrderDTO> orderDTO = orderRepository.getOneById(id).map(orderMapper::toDto);
        if (orderDTO.isPresent()) {
            OrderDTO orderDTO1 = orderDTO.get();
            orderDTO1.setUser(loadUserData(orderDTO1.getUserId()));
            return orderDTO1;
        }

        return null;
    }

    public OrderDTO saveOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        return orderMapper.toDto(orderRepository.save(order));
    }

    private UserDTO loadUserData(Long userId) {
        return userResourceClient.getOne(userId).getBody();
    }

}
