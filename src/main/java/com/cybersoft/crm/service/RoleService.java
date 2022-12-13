package com.cybersoft.crm.service;

import com.cybersoft.crm.dto.RoleDTO;
import com.cybersoft.crm.entity.RoleEntity;

import java.util.List;

public interface RoleService {
    List<RoleDTO> getAllRoles();
    RoleEntity updateRole(int id, RoleEntity roleEntity);
    RoleEntity addNewRole(RoleEntity roleEntity);
    void deleteRole(int id);
}
