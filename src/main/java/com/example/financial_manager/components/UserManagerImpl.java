package com.example.financial_manager.components;

import com.example.financial_manager.controllers.exceptionHandler.exceptions.NoSuchExpanseException;
import com.example.financial_manager.dto.*;
import com.example.financial_manager.entities.ExpenseEntity;
import com.example.financial_manager.entities.UserEntity;
import com.example.financial_manager.managers.UserManager;
import com.example.financial_manager.mappers.ExpenseMapper;
import com.example.financial_manager.mappers.UserMapper;
import com.example.financial_manager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserManagerImpl implements UserManager {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    @Override
    public UserDto addUser(UserDto userDto) {
        UserEntity userEntity = userMapper.userDtoToEntity(userDto);
        userRepository.save(userEntity);
        return userMapper.userEntityToDto(userEntity);
    }

    @Override
    public void deleteUser(Long id) {
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }else{
            throw new RuntimeException("No such user");
        }
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        if(userRepository.findById(id).isPresent()){
            UserEntity userEntity = userMapper.userDtoToEntity(userDto);
            userEntity.setId(id);
            userRepository.save(userEntity);
            return userMapper.userEntityToDto(userEntity);
        }else{
            throw new NoSuchExpanseException(id);
        }
    }


    @Override
    public UserDto getUserById(Long id) {
        if(userRepository.findById(id).isPresent()){
            return userMapper.userEntityToDto(userRepository.findById(id).get());
        }else{
            throw new NoSuchExpanseException(id);
        }
    }

    public UserEntity getUserEntityById(Long id) {
        if(userRepository.findById(id).isPresent()){
            return userRepository.findById(id).get();
        }else{
            throw new NoSuchExpanseException(id);
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public List<ExpenseDto> getAllExpanses() {
        return null;
    }

    @Override
    public List<IncomeDto> getAllIncomes() {
        return null;
    }

    @Override
    public List<LoanDto> getAllLoans() {
        return null;
    }

    @Override
    public List<StockDto> getAllStocks() {
        return null;
    }
}
