package com.cybersoft.crm.controller;

import com.cybersoft.crm.dto.RoleDTO;
import com.cybersoft.crm.entity.RoleEntity;
import com.cybersoft.crm.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<?> getAllRoles(){
        List<RoleDTO> roleDTOS = new ArrayList<>();
        roleDTOS = roleService.getAllRoles();

        return new ResponseEntity<>(roleDTOS, HttpStatus.OK);
    }

    @PostMapping ("/update-role")
    public ResponseEntity<RoleDTO> updateRole(@RequestBody RoleDTO roleDTO) {

        // convert DTO to Entity
        RoleEntity roleRequest = modelMapper.map(roleDTO, RoleEntity.class);

        RoleEntity roleEntity = roleService.updateRole(roleDTO.getId(), roleRequest);
        System.out.println("Kiem tra updateRole");

        // entity to DTO
        RoleDTO roleResponse = modelMapper.map(roleEntity, RoleDTO.class);

        return ResponseEntity.ok().body(roleResponse);
    }

    @PostMapping("/add-role")
    public ResponseEntity<RoleDTO> addRole(@RequestBody  RoleDTO roleDTO){
        // convert DTO to Entity
        RoleEntity roleRequest = modelMapper.map(roleDTO, RoleEntity.class);

        RoleEntity roleEntity = roleService.addNewRole(roleRequest);
        System.out.println("Kiem tra addNewRole");
        // entity to DTO
        RoleDTO roleResponse = modelMapper.map(roleEntity, RoleDTO.class);

        return new ResponseEntity<>(roleResponse, HttpStatus.CREATED);
    }

    @PostMapping("/delete-role")
    public ResponseEntity<?> deleteRole(@RequestParam int id){

        roleService.deleteRole(id);

        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
