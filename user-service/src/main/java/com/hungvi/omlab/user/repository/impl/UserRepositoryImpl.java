package com.hungvi.omlab.user.repository.impl;

import com.hungvi.omlab.user.entity.UserEntity;
import com.hungvi.omlab.user.infras.dao.UserDAO;
import com.hungvi.omlab.user.model.*;
import com.hungvi.omlab.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserRepositoryImpl implements UserRepository {

    private final UserDAO dao;

    @Override
    public Optional<User> findById(Integer id) {
        return this.dao.findById(id)
                .map(this::entityToModel);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.dao.findByEmail(email)
                .map(this::entityToModel);
    }

    @Override
    public User save(User user) {
        UserEntity entity = modelToEntity(user);
        this.dao.saveAndFlush(entity);

        return user.toBuilder()
                .id(UserId.of(entity.getId()))
                .build();
    }

    private User entityToModel(UserEntity entity) {
        return User.builder()
                .id(UserId.of(entity.getId()))
                .firstName(FirstName.of(entity.getFirstName()))
                .lastName(LastName.of(entity.getLastName()))
                .email(EmailAddress.of(entity.getEmail()))
                .build();
    }

    private UserEntity modelToEntity(User model) {
        UserEntity.UserEntityBuilder entity = UserEntity.builder();
        if (model.getId() != null) {
            entity.id(model.getId().toInt());
        }
        return entity
                .firstName(model.getFirstName().toString())
                .lastName(model.getLastName().toString())
                .email(model.getEmail().toString())
                .build();

    }
}
