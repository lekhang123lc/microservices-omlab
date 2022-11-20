package com.hungvi.omlab.user.service.impl;

import com.hungvi.omlab.common.api.response.ErrorCode;
import com.hungvi.omlab.common.exception.ResourceNotFoundException;
import com.hungvi.omlab.common.exception.ResourceViolationException;
import com.hungvi.omlab.common.model.event.Action;
import com.hungvi.omlab.user.api.request.UserCreateRQ;
import com.hungvi.omlab.user.api.request.UserUpdateRQ;
import com.hungvi.omlab.user.infras.config.kafka.UserEventProducer;
import com.hungvi.omlab.user.model.EmailAddress;
import com.hungvi.omlab.user.model.FirstName;
import com.hungvi.omlab.user.model.LastName;
import com.hungvi.omlab.user.model.User;
import com.hungvi.omlab.user.repository.UserRepository;
import com.hungvi.omlab.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserEventProducer userEventProducer;


    @Override
    public User getUser(int userId) throws ResourceNotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User [" + userId + "] not found"));
    }

    @Override
    public User createUser(UserCreateRQ userCreateRQ) throws ResourceViolationException {
        checkDuplicateEmail(userCreateRQ.getEmail());
        User user = User.builder()
                .firstName(FirstName.of(userCreateRQ.getFirstName()))
                .lastName(LastName.of(userCreateRQ.getLastName()))
                .email(EmailAddress.of(userCreateRQ.getEmail()))
                .build();
        User createdUser = userRepository.save(user);
        userEventProducer.publish(Action.CREATE, createdUser.getId());
        return createdUser;
    }

    @Override
    public User updateUser(int userId, UserUpdateRQ userUpdateRQ) throws ResourceNotFoundException, ResourceViolationException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User [" + userId + "] not found"));
        checkDuplicateEmail(userUpdateRQ.getEmail());
        User modifiedUser = user.toBuilder()
                .firstName(FirstName.of(userUpdateRQ.getFirstName()))
                .lastName(LastName.of(userUpdateRQ.getLastName()))
                .email(EmailAddress.of(userUpdateRQ.getEmail()))
                .build();
        modifiedUser = userRepository.save(modifiedUser);
        userEventProducer.publish(Action.MODIFY, modifiedUser.getId());
        return modifiedUser;
    }

    private void checkDuplicateEmail(String email) throws ResourceViolationException {
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            throw new ResourceViolationException(ErrorCode.USER_ALREADY_EXISTS, "User already exists");
        }
    }
}
