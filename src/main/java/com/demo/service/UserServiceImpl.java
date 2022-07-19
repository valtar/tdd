package com.demo.service;

import com.demo.client.StrangeUserModel;
import com.demo.client.UserClient;
import com.demo.converter.UserMapper;
import com.demo.model.User;
import com.demo.model.UserDto;
import com.demo.repository.UserRepository;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private UserClient userClient;

    @Override
    public void create(String login) {
        validateLogin(login);

        User user = new User(login);

        userRepository.save(user);
    }

    @Override
    public void create(UserDto userDto) {
        validateLogin(userDto.getLogin());
        User user = userMapper.toUser(userDto);

        userRepository.save(user);
    }

    @Override
    public User findByLoginAndEmail(String login, String email) {
        return userRepository.findByLoginAndEmail(login, email).get();
    }

    private void validateLogin(String login) {
        if (login == null || login.isBlank()) {
            throw new IllegalArgumentException("login is empty");
        }
    }
}
