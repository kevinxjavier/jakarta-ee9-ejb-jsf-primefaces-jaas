package com.kevinpina.controllers;

import com.kevinpina.models.UserDTO;
import com.kevinpina.services.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.logging.Logger;

@Model
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class.getName());

    @Getter
    @Setter
    private UserDTO userDTO;

    @Inject
    private UserService userService;

    @Getter
    @Setter
    private List<UserDTO> listUsers;

    @PostConstruct
    public void init() {
        reset();
    }

    public String saveUser() {
        log.info("UserController.saveUser(): {}" + userDTO);
        userService.addUser(userDTO);

        reset();
        return "index.xhtml";
    }

    private void reset() {
        this.userDTO = new UserDTO();
        this.listUsers = userService.listUsers();
    }

}
