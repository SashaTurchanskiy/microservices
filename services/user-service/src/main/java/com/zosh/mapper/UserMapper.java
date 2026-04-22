package com.zosh.mapper;

import com.zosh.model.User;
import com.zosh.payload.dto.UserDTO;

import java.util.List;

public class UserMapper {

    public static UserDTO toDTO(User user){
        if(user == null) return null;

        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .phone(user.getPhone())
                .role(user.getRole())
                .lastLogin(user.getLastLoginAt())
                .build();
    }

    public static List<UserDTO> toDTOList(List<User> users){
        return users.stream().map(UserMapper::toDTO).toList();
    }
}
