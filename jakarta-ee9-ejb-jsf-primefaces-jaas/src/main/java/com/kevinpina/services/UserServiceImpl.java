package com.kevinpina.services;

import com.kevinpina.entities.UserEntity;
import com.kevinpina.mappers.UserMapper;
import com.kevinpina.models.UserDTO;
import com.kevinpina.repositories.CrudRepository;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless // Defining a EJB and also with this annotation creating a CDI component. Automatically the interface will be @Local by default
@DeclareRoles({"USER", "ADMIN"})
public class UserServiceImpl implements  UserService {

    @Inject
    private CrudRepository<UserEntity> userRepository;

    @Inject
    private UserMapper userMapper;

    @PermitAll
    @Override
    public List<UserDTO> listUsers() {
        return userRepository.list().stream().map(userMapper::toDTO).toList();
    }

    @RolesAllowed({"USER", "ADMIN"})
    @Override
    public UserDTO getUser(Long id) {
        return userMapper.toDTO(userRepository.findById(id));
    }

    @RolesAllowed({"ADMIN"})
    @Override
    public void addUser(UserDTO user) {
        userRepository.save(userMapper.toEntity(user));
    }

    @RolesAllowed({"ADMIN"})
    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

}
