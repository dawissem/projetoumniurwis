package com.sesame.projetnourouma.Mapper;

import com.sesame.projetnourouma.Dto.UserDto;
import com.sesame.projetnourouma.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface UserMapper {
    UserDto toUserDto(User user);
    User toUser(UserDto userDto );
}
