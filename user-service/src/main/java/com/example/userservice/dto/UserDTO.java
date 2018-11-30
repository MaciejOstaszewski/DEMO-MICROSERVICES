package com.example.userservice.dto;

import com.example.userservice.mapper.ViewModel;
import lombok.Data;

@Data
public class UserDTO implements ViewModel {

    private Long id;

    private String firstName;

    private String lastName;
}
