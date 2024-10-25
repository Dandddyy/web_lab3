package com.example.web_lab3;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> user = userService.getUsers();
        return ResponseEntity.ok(user);
    }

}
