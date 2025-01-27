package com.artesanias.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserVo {
    private String id;
    private String email;
    private String password;
    private String role;
}
