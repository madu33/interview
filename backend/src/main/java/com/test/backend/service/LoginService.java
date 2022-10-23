package com.test.backend.service;

import com.test.backend.dto.LoginDTO;

import java.util.List;

public interface LoginService {
    boolean userLogin(LoginDTO loginDTO);

    boolean storeDataOnLoginTable(List<LoginDTO> users);
}
