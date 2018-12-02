package com.example.userservice.service;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.mapper.UserMapper;
import com.example.userservice.repostiory.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        return userMapper.toDtos(userRepository.findAll());
    }

    public Optional<UserDTO> getUser(Long id) {
        return userRepository.getOneById(id).map(userMapper::toDto);
    }

}
