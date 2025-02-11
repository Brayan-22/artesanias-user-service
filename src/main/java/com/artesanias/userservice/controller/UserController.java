package com.artesanias.userservice.controller;

import com.artesanias.userservice.dto.CreateUserRequest;
import com.artesanias.userservice.dto.UserRequestDto;
import com.artesanias.userservice.dto.UserResponseDto;
import com.artesanias.userservice.dto.ValidateUserResponseDto;
import com.artesanias.userservice.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> save(@RequestBody CreateUserRequest request) {
        UserResponseDto user = userService.save(request);
        return ResponseEntity.ok(user);
    }


    @PostMapping("/validate")
    public ResponseEntity<ValidateUserResponseDto> validateUser(@RequestBody UserRequestDto userResponseDto){
        ValidateUserResponseDto resultUser = userService.validateUser(userResponseDto.getEmail(),userResponseDto.getPassword());
        return ResponseEntity.ok(resultUser);
    }


    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponseDto> findByEmail(@PathVariable String email) {
        UserResponseDto user = userService.findByEmail(email);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/email/{email}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable String mail,CreateUserRequest request){
        UserResponseDto user = userService.updateUser(mail,request);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/email/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email){
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }
}
