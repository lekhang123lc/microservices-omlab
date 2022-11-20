package com.hungvi.omlab.user.repository;

import com.hungvi.omlab.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {

    User save(User user);

    Optional<User> findById(Integer id);

    Optional<User> findByEmail(String email);

}
