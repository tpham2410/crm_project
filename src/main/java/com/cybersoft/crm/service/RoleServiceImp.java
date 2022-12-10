package com.cybersoft.crm.service;

import com.cybersoft.crm.dto.RoleDTO;
import com.cybersoft.crm.entity.RoleEntity;
import com.cybersoft.crm.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImp implements RoleService{

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<RoleDTO> getAllRoles() {
        List<RoleEntity> roleEntities = roleRepository.findAll();
        List<RoleDTO> dtos = new ArrayList<>();

        for (RoleEntity roleData: roleEntities){
            RoleDTO roleDTO = new RoleDTO();

            roleDTO.setId(roleData.getId());
            roleDTO.setName(roleData.getName());
            roleDTO.setDescription(roleData.getDescription());

            dtos.add(roleDTO);
        }


        return dtos;
    }
}
