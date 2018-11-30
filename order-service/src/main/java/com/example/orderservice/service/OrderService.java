package com.example.orderservice.service;

import com.example.orderservice.UserResourceClient;
import com.example.orderservice.domain.Order;
import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.dto.UserDTO;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private UserResourceClient userResourceClient;

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
//    private static OrderService instance;
//
//    private List<Order> orders = Arrays.asList(
//            new Order(1L, 1L, "product1", BigDecimal.valueOf(10), 3L, null),
//            new Order(2L, 2L, "product2", BigDecimal.valueOf(5.5), 2L, null),
//            new Order(3L, 3L, "product3", BigDecimal.valueOf(4.6), 1L, null),
//            new Order(4L, 2L, "product4", BigDecimal.valueOf(12.2), 1L, null),
//            new Order(5L, 1L, "product5", BigDecimal.valueOf(10.4), 2L, null)
//    );
//
//    private synchronized static void initialize() {
//        instance = new OrderService();
//    }
//
//    public synchronized static OrderService getInstance() {
//        if(isNull(instance)) {
//            initialize();
//        }
//        return instance;
//    }
//
//    public synchronized List<Order> getAll() {
//        return orders;
//    }
//
//    public Optional<Order> findById(Long id) {
//        return orders.stream().filter(order -> order.getId().equals(id)).findFirst();
//    }

}
