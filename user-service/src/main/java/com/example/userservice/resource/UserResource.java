package com.example.userservice.resource;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserResource {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        log.debug("Rest request for all users");
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return userService.getUser(id)
                .map(userDTO -> new ResponseEntity<>(userDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
