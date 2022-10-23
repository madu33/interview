package com.test.backend.controller;

import com.test.backend.dto.LoginDTO;
import com.test.backend.service.LoginService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Component
@RestController
@RequestMapping("/api")
public class LoginController implements InitializingBean {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public boolean userLogin(@RequestBody LoginDTO loginDTO){

        return loginService.userLogin(loginDTO);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        List<LoginDTO>users=new ArrayList<>();
        users.add(new LoginDTO("Hashan","1234"));
        users.add(new LoginDTO("Jamith","1234"));
        loginService.storeDataOnLoginTable(users);
    }
}
