package com.example.mycrud.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.mycrud.model.dtoUser.UserCreateDTO;
import com.example.mycrud.model.dtoUser.UserReadDTO;
import com.example.mycrud.model.dtoUser.UserUpdateDTO;
import com.example.mycrud.utils.ApiResponse;

public interface IUserService {
    ResponseEntity<ApiResponse<List<UserReadDTO>>> getUsers();

    ResponseEntity<ApiResponse<UserReadDTO>> getUserById(Integer id);

    ResponseEntity<ApiResponse<UserReadDTO>> createUser(UserCreateDTO userCreateDTO);

    ResponseEntity<ApiResponse<UserReadDTO>> updateUser(Integer id, UserUpdateDTO userUpdateDTO);

    ResponseEntity<ApiResponse<Void>> deleteUser(Integer id);

    ResponseEntity<ApiResponse<String>> login(String email, String password);

}
