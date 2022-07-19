package com.demo.converter;

import com.demo.model.User;
import com.demo.model.UserDto;

public interface UserMapper {
    User toUser(UserDto dto);
}
