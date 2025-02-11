package com.artesanias.userservice.service.impl;

import com.artesanias.userservice.dto.CreateUserRequest;
import com.artesanias.userservice.dto.UserResponseDto;
import com.artesanias.userservice.dto.ValidateUserResponseDto;
import com.artesanias.userservice.entity.Cliente;
import com.artesanias.userservice.entity.Ubicacion;
import com.artesanias.userservice.entity.UserEntity;
import com.artesanias.userservice.exception.UserNotCreatedException;
import com.artesanias.userservice.exception.UserNotFoundException;
import com.artesanias.userservice.repository.ClienteRepository;
import com.artesanias.userservice.repository.UbicacionRepository;
import com.artesanias.userservice.repository.UserRepository;
import com.artesanias.userservice.service.IUserService;
import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final ClienteRepository clienteRepository;
    private final UbicacionRepository ubicacionRepository;


    @Transactional(rollbackOn = UserNotCreatedException.class)
    public UserResponseDto save(CreateUserRequest request) throws UserNotCreatedException {
        if (userRepository.existsByEmail(request.getEmail())) throw new UserNotCreatedException("Ya existe un usario con este correo");

        Ubicacion u = ubicacionRepository.findByDireccion(request.getDireccion())
                .orElseGet(() -> Ubicacion.builder().direccion(request.getDireccion()).build());

        UserEntity userEntity = UserEntity.builder()
                .password(request.getPassword())
                .role("CLIENTE")
                .email(request.getEmail())
                .build();

        Cliente cliente = Cliente.builder()
                .nombres(request.getNombre())
                .apellidos(request.getApellido())
                .direccion(request.getDireccion())
                .idUbicacionfk(u)
                .idUsuariofk(userEntity)
                .build();

        clienteRepository.saveAndFlush(cliente);

        return new UserResponseDto(userEntity.getId(), userEntity.getEmail(), userEntity.getRole());
    }


    @Override
    public UserResponseDto findByEmail(String email)throws UserNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));
        return UserResponseDto.builder()
                .email(userEntity.getEmail())
                .role(userEntity.getRole())
                .build();
    }

    @Transactional
    @Override
    public UserResponseDto updateUser(String username, CreateUserRequest request)throws UserNotFoundException, UserNotCreatedException {
        UserEntity userEntity = userRepository.findByEmail(username).orElseThrow(() -> new UserNotFoundException("User not found"));
        userEntity.setEmail(request.getEmail());
        userEntity.setPassword(request.getPassword());
        userRepository.save(userEntity);
        return UserResponseDto.builder()
                .email(userEntity.getEmail())
                .role(userEntity.getRole())
                .build();
    }

    @Override
    public void deleteUser(String username)throws UserNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(username).orElseThrow(() -> new UserNotFoundException("User not found"));
        userRepository.delete(userEntity);
    }

    @Override
    public ValidateUserResponseDto validateUser(String email, String password) throws UserNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));
        return ValidateUserResponseDto.builder()
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .id(userEntity.getId())
                .role(userEntity.getRole())
                .build();
    }
}
