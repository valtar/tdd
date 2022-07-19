package com.demo.service;

import com.demo.model.User;
import com.demo.model.UserDto;

public interface UserService {
    void create(String login);
    void create(UserDto userDto);

    User findByLoginAndEmail(String login, String email);
}
