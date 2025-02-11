package com.artesanias.userservice.service;

import com.artesanias.userservice.dto.CreateUserRequest;
import com.artesanias.userservice.dto.UserResponseDto;
import com.artesanias.userservice.dto.ValidateUserResponseDto;
import com.artesanias.userservice.exception.UserNotCreatedException;
import com.artesanias.userservice.exception.UserNotFoundException;

public interface IUserService {
    UserResponseDto save(CreateUserRequest request)throws UserNotCreatedException;
    UserResponseDto findByEmail(String email)throws UserNotFoundException;
    UserResponseDto updateUser(String mail, CreateUserRequest request)throws UserNotFoundException, UserNotCreatedException;
    void deleteUser(String mail)throws UserNotFoundException;
    ValidateUserResponseDto validateUser(String email, String password)throws UserNotFoundException;
}
