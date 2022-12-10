package com.cybersoft.crm.controller;

import com.cybersoft.crm.payload.request.SigninRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signin")
public class LoginController {

    @PostMapping("")
    public ResponseEntity<?> index(@RequestBody SigninRequest signinRequest){

        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
