package com.example.mycrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mycrud.model.dtoUser.UserCreateDTO;
import com.example.mycrud.model.dtoUser.UserLoginDTO;
import com.example.mycrud.model.dtoUser.UserReadDTO;
import com.example.mycrud.model.dtoUser.UserUpdateDTO;
import com.example.mycrud.service.IUserService;
import com.example.mycrud.utils.ApiResponse;
import com.example.mycrud.utils.ValidationExceptionHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserReadDTO>>> getUsers() {
        return userService.getUsers();
    }

    // Endpoint para obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserReadDTO>> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    // Endpoint para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<ApiResponse<UserReadDTO>> createUser(@RequestBody @Valid UserCreateDTO userCreateDTO) {
        return userService.createUser(userCreateDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        String email = userLoginDTO.getEmail();
        String password = userLoginDTO.getPassword();
        return userService.login(email, password);
    }

    // Endpoint para actualizar un usuario
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserReadDTO>> updateUser(@PathVariable Integer id,
            @RequestBody UserUpdateDTO userUpdateDTO) {
        return userService.updateUser(id, userUpdateDTO);
    }

    // Endpoint para eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    // Endpoint para iniciar sesión

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<List<String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ValidationExceptionHandler.handleValidationExceptions(ex);
    }

}
