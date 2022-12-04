package com.cybersoft.crm.controller;

import com.cybersoft.crm.payload.request.SigninRequest;
import com.cybersoft.crm.payload.response.DataResponse;
import com.cybersoft.crm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signin")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("")
    public ResponseEntity<?> index(@RequestBody SigninRequest signinRequest){
        boolean isSuccess = loginService.checkLogin(signinRequest.getUsername(), signinRequest.getPassword());
        DataResponse dataResponse = new DataResponse();

        if(isSuccess == true){

            dataResponse.setStatus(200);
            dataResponse.setDescription("");
            dataResponse.setData("");
            dataResponse.setSuccess(isSuccess);

            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        }
        dataResponse.setDescription("");
        dataResponse.setData("");
        dataResponse.setStatus(HttpStatus.FORBIDDEN.value());

        return new ResponseEntity<>(dataResponse, HttpStatus.FORBIDDEN);
    }
}
