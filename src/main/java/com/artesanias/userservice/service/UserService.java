package com.artesanias.userservice.service;

import com.artesanias.userservice.dto.UserVo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class UserService {
    public UserVo save(UserVo userVo) {
        //Por ahora se simula la operacion guardar
        String userId = String.valueOf(new Date().getTime());
        userVo.setId(userId);
        userVo.setRole("USER");
        //Guardado....
        return userVo;
    }
}
