package com.example.financial_manager.managers;

import com.example.financial_manager.dto.ExpenseDto;
import com.example.financial_manager.dto.UserDto;
import com.example.financial_manager.entities.ExpenseEntity;
import com.example.financial_manager.entities.UserEntity;
import com.example.financial_manager.mappers.UserMapper;
import com.example.financial_manager.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class UserManagerImplTests {
    @Mock
    private UserMapper userMapper;
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserManager userManager;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddUser() {
        UserDto userDto = new UserDto(null, "fww@gmail.com", "ff", "1111");
        UserEntity userEntity = new UserEntity(null, "fww@gmail.com", "ff", "1111");

        when(userMapper.userDtoToEntity(userDto)).thenReturn(userEntity);
        when(userManager.addUser(userDto)).thenReturn(userDto);
        when(userRepository.save(userEntity)).thenReturn(userEntity);

        UserDto result = userManager.addUser(userDto);
        assertNotNull(result);
        assertEquals(userDto, result);
    }


    @Test
    public void testUpdateUser() {
        UserDto userDto = new UserDto(null, "fww@gmail.com", "ff", "1111");
        UserEntity userEntity = new UserEntity(null, "fww@gmail.com", "ff", "1111");

        when(userManager.updateUser(1L,userDto)).thenReturn(userDto);

        String email = "fww@gmail.com";
        assertEquals(userDto.getEmail(), email);
    }

    @Test
    public void testDeleteUser() {
        Long id = 1L;

        userManager.deleteUser(id);

        assert(!userRepository.findById(id).isPresent());
    }
}
