package com.demo.repository;

import com.demo.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FakeUserRepository implements UserRepository {
    private final List<User> users = new ArrayList<>();
    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return users.stream()
                .filter(user -> user.getLogin().equalsIgnoreCase(login))
                .findFirst();
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
