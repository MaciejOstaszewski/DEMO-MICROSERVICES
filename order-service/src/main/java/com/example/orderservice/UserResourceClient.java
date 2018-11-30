package com.example.orderservice;

import com.example.orderservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "userservice", path = "/api/users")
public interface UserResourceClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
        ResponseEntity<UserDTO> getOne(@PathVariable(value = "id") Long id);

}
