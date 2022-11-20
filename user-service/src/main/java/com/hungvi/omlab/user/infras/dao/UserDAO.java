package com.hungvi.omlab.user.infras.dao;

import com.hungvi.omlab.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmail(String email);

}