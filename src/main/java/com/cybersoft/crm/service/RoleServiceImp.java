package com.cybersoft.crm.service;

import com.cybersoft.crm.dto.RoleDTO;
import com.cybersoft.crm.entity.RoleEntity;
import com.cybersoft.crm.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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



    @Override
    public RoleEntity updatePost(int id, RoleEntity roleRequest) {
        RoleEntity role = roleRepository.findById(id).orElseThrow();

        if (role == null) {
            return null;
        } else {
            role.setId(roleRequest.getId());
            role.setName(roleRequest.getName());
            role.setDescription(roleRequest.getDescription());

            return roleRepository.save(role);
        }
    }

//
//    @Override
//    public RoleEntity updatePost(int id, RoleEntity roleEnityRequest) {
//        Optional<RoleEntity> roleEnity = roleRepository.findById(id).
//                orElseThrow(() -> new ResourceNotFoundException("RoleEntity", "id", id)););)
//        RoleDTO role = new RoleDTO();
//        roleEnity.
//        role.setId(roleEnity.get().getId());
//        role.setName(roleEnity.get().getName());
//        role.setDescription(roleEnity.get().getDescription());
//
//        roleEnity.
//        return roleRepository.save(role);
//    }


    @Override
    public void deleteRole(int id) {

    }
}
