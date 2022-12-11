package com.cybersoft.crm.service;

import com.cybersoft.crm.dto.RoleDTO;
import com.cybersoft.crm.entity.RoleEntity;
import com.cybersoft.crm.model.RoleModel;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<RoleDTO> getAllRoles();
    RoleEntity updatePost(int id, RoleEntity roleEntity);
    void deleteRole(int id);
}
