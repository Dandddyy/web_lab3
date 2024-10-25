package com.example.web_lab3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper = UserMapper.INSTANCE;

    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(mapper::toUserDTO).toList();
    }
}