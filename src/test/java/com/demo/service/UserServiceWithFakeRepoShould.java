package com.demo.service;

import com.demo.repository.FakeUserRepository;
import com.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;

@ExtendWith(MockitoExtension.class)
public class UserServiceWithFakeRepoShould {

    private UserRepository userRepository = spy(FakeUserRepository.class);

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void createUser() {
        userService.create("testLogin");

        assertTrue(userRepository.findByLogin("testLogin").isPresent());
    }
}
