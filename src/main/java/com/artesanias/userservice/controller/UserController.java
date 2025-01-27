package com.artesanias.userservice.controller;

import com.artesanias.userservice.dto.UserVo;
import com.artesanias.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserVo> save(@RequestBody UserVo userVo) {
        return ResponseEntity.ok(userService.save(userVo));
    }

    @GetMapping("/secured")
    public ResponseEntity<String> securedEndpoint() {
        return ResponseEntity.ok("Este es una simulacion de un endpoint seguro");
    }
}
