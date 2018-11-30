package com.example.orderservice.mapper;

import static java.util.Objects.isNull;

public interface IEntity {
    Long getId();

    default boolean isNew(){
        return isNull(getId());
    }
}
