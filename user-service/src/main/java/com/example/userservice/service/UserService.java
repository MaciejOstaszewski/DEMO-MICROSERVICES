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

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        List users = userRepository.findAll();
        return userMapper.toDtos(users);
    }

    public Optional<UserDTO> getUser(Long id) {
        return userRepository.getOneById(id).map(userMapper::toDto);
    }

//    private static UserService instance;
//
//    private List<User> users = Arrays.asList(
//            new User(1L, "User1", "User1"),
//            new User(2L, "User2", "User2"),
//            new User(3L, "User3", "User3")
//    );
//
//    public static synchronized void initialize() {
//        instance = new UserService();
//    }
//
//    public static synchronized UserService getInstance() {
//        if(isNull(instance)) {
//            initialize();
//        }
//        return instance;
//    }
//
//    public synchronized List<User> getAll() {
//        return users;
//    }
//
//    public Optional<User> findById(Long id) {
//        return users.stream().filter(u -> u.getId().equals(id)).findFirst();
//    }
}
