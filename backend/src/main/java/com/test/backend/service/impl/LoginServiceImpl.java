package com.test.backend.service.impl;

import com.test.backend.dto.LoginDTO;
import com.test.backend.entity.Login;
import com.test.backend.repo.LoginRepo;
import com.test.backend.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LoginRepo loginRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean userLogin(LoginDTO loginDTO) {
        Login login = modelMapper.map(loginDTO, Login.class);
        Login byUserName = loginRepo.findByUserName(login.getUserName());

        if(login.getUserName().equals(byUserName.getUserName())){
            System.out.println(passwordEncoder.matches(login.getPassword(),byUserName.getPassword()));
            if(passwordEncoder.matches(login.getPassword(),byUserName.getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean storeDataOnLoginTable(List<LoginDTO> users) {
        Login login=new Login();
        List<Login> all = loginRepo.findAll();
        if(all.size()==0){
            for (LoginDTO obj:users){
                Login user = modelMapper.map(obj, Login.class);
                user.setPassword(passwordEncoder.encode(obj.getPassword()));
                login = loginRepo.save(user);
            }
            if(login !=null){
                return true;
            }
        }
        return false;
    }
}
