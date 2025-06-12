package com.kevinpina.mappers;

import com.kevinpina.entities.UserEntity;
import com.kevinpina.models.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "jakarta") // or "spring" or "default"
public interface UserMapper {

    //UserMapper INSTANCE = Mappers.getMapper(UserMapper.class); // But since we are using: @Mapper(componentModel = "jakarta")

    //@Mapping(source = "name", target = "name")
    //@Mapping(source = "address", target = "address")
    UserDTO toDTO(UserEntity entity);

    //@Mapping(source = "name", target = "name")
    //@Mapping(source = "address", target = "address")
    UserEntity toEntity(UserDTO dto);

}
