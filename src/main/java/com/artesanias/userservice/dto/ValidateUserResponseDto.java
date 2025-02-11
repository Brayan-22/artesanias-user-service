package com.artesanias.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidateUserResponseDto {
    private String id;
    private String email;
    private String password;
    private String role;
}
