package com.hungvi.omlab.user.api.controller;

import com.hungvi.omlab.common.api.response.CreatedResponse;
import com.hungvi.omlab.common.api.response.ResourceResponse;
import com.hungvi.omlab.user.api.request.UserCreateRQ;
import com.hungvi.omlab.user.api.request.UserUpdateRQ;
import com.hungvi.omlab.user.api.response.UserRS;
import com.hungvi.omlab.common.exception.ResourceNotFoundException;
import com.hungvi.omlab.common.exception.ResourceViolationException;
import com.hungvi.omlab.user.model.User;
import com.hungvi.omlab.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RestController
@RequestMapping("/api/user/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id:\\d+}")
    public ResourceResponse<UserRS> retrieve(@PathVariable("id") int id) throws ResourceNotFoundException {
        log.info("Retrieve user: {}", id);
        User user = userService.getUser(id);
        return new ResourceResponse<>(UserRS.of(user));
    }

    @PostMapping
    public CreatedResponse<UserRS> create(@RequestBody @Valid UserCreateRQ userCreateRQ) throws ResourceViolationException {
        log.info("Create user: {}", userCreateRQ);
        User createdUser = userService.createUser(userCreateRQ);
        UserRS userRS = UserRS.of(createdUser);
        return new CreatedResponse<>(userRS);
    }

    @PatchMapping("/{id:\\d+}")
    public ResourceResponse<UserRS> update(@PathVariable("id") int id, @RequestBody @Valid UserUpdateRQ userUpdateRQ) throws ResourceViolationException, ResourceNotFoundException {
        log.info("Update user: {}", userUpdateRQ);
        User createdUser = userService.updateUser(id, userUpdateRQ);
        UserRS userRS = UserRS.of(createdUser);
        return new ResourceResponse<>(userRS);
    }

}
