package com.kevinpina.services;

import com.kevinpina.models.UserDTO;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface UserService {

    List<UserDTO> listUsers();
    UserDTO getUser(Long id);
    void addUser(UserDTO user);
    void removeUser(Long id);

}
