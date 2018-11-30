package com.example.orderservice.domain;

import com.example.orderservice.dto.UserDTO;
import com.example.orderservice.mapper.IEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order implements IEntity {

    @Id
    private Long id;

    @Column
    private String product;

    @Column
    private BigDecimal price;

    @Column
    private Long quantity;

    @Column(name = "user_id")
    private Long userId;

}
