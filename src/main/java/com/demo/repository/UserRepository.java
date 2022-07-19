package com.demo.repository;

import com.demo.model.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);

    Optional<User> findByLogin(String login);

    Optional<User> findByLoginAndEmail(String login, String email);

    Optional<User> findByLoginAndEmail(Integer login, Integer email);
}
