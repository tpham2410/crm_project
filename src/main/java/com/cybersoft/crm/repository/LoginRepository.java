package com.cybersoft.crm.repository;

import com.cybersoft.crm.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<UserEntity,Integer> {
    List<UserEntity> findUserByEmailAndPassword(String email, String password);

}
