package com.hungvi.omlab.user.service;

import com.hungvi.omlab.user.api.request.UserCreateRQ;
import com.hungvi.omlab.user.api.request.UserUpdateRQ;
import com.hungvi.omlab.common.exception.ResourceNotFoundException;
import com.hungvi.omlab.common.exception.ResourceViolationException;
import com.hungvi.omlab.user.model.User;

public interface UserService {

    User getUser(int userId) throws ResourceNotFoundException;

    User createUser(UserCreateRQ userCreateRQ) throws ResourceViolationException;

    User updateUser(int userId, UserUpdateRQ userUpdateRQ) throws ResourceNotFoundException, ResourceViolationException;

}
