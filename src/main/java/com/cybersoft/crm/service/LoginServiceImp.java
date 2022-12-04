package com.cybersoft.crm.service;

import com.cybersoft.crm.entity.UserEntity;
import com.cybersoft.crm.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImp implements LoginService{

    @Autowired
    LoginRepository loginRepository;

    @Override
    public boolean checkLogin(String email, String password) {
        boolean isSuccess = false;
        List<UserEntity> userEntities = loginRepository.findUserByEmailAndPassword(email,password);
        System.out.println(email + " + " + password);
        if(userEntities.size() > 0){
            isSuccess = true;
        }
        return isSuccess;
    }
}
