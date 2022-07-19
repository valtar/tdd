package com.demo.repository;

import com.demo.model.User;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public void save(User user) {
        //do-something
    }

    @Override
    public Optional<User> findByLogin(String login) {
        //TODO: bd query
        return Optional.empty();
    }

    @Override
    public Optional<User> findByLoginAndEmail(String login, String email) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByLoginAndEmail(Integer login, Integer email) {
        return Optional.empty();
    }
}
