package com.demo.service;

import com.demo.client.UserClient;
import com.demo.converter.UserMapper;
import com.demo.converter.UserMapperImpl;
import com.demo.model.User;
import com.demo.model.UserDto;
import com.demo.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceShould {

    @Mock
    private UserRepository userRepository;

    @Spy
    private UserMapperImpl userMapper;

    @Mock
    private UserClient userClient;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void mockLogin() {
        lenient().when(userRepository.findByLogin("re")).thenReturn(Optional.empty());
    }

    @Test
    void createUser() {
        userService.create("testLogin");

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void createUserByDto() {
        UserDto userDto = new UserDto();
        userDto.setLogin("testLogin");

        userService.create(userDto);

        verify(userMapper, times(1)).toUser(userDto);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void createUserByDtoCheckUser() {
        UserDto userDto = new UserDto();
        userDto.setLogin("testLogin");

        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        ArgumentCaptor<UserDto> userDtoArgumentCaptor = ArgumentCaptor.forClass(UserDto.class);

        userService.create(userDto);

        verify(userMapper, times(1)).toUser(userDtoArgumentCaptor.capture());
        verify(userRepository, times(1)).save(userArgumentCaptor.capture());
        verifyNoInteractions(userClient);
        verifyNoMoreInteractions(userMapper, userRepository);
    }

    @Test
    void throwException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> userService.create(""));
        assertEquals("login is empty", exception.getMessage());
    }

    @Test
    void tsdfa() {
        User user = new User();
        user.setLogin("1");
        User user2 = new User();
        user2.setLogin("2");

        when(userRepository.findByLoginAndEmail(anyString(), anyString())).thenReturn(Optional.of(user2));

        when(userRepository.findByLoginAndEmail(eq("testLogin"), eq("testEmail"))).thenReturn(Optional.of(user));


        assertEquals("1", userService.findByLoginAndEmail("testLogin", "testEmail").getLogin());
        assertEquals("2", userService.findByLoginAndEmail("12312", "321").getLogin());
    }
}
