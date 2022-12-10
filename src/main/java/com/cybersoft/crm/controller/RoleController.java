package com.cybersoft.crm.controller;

import com.cybersoft.crm.dto.RoleDTO;
import com.cybersoft.crm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("")
    public ResponseEntity<?> getAllRoles(){
        List<RoleDTO> roleDTOS = new ArrayList<>();
        roleDTOS = roleService.getAllRoles();

        return new ResponseEntity<>(roleDTOS, HttpStatus.OK);
    }
}
