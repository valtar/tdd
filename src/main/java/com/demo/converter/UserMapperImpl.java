package com.demo.converter;

import com.demo.model.User;
import com.demo.model.UserDto;

public class UserMapperImpl implements UserMapper {
    public User toUser(UserDto dto) {
        User user = new User();
        user.setLogin(dto.getLogin());
        return user;
    };
}
