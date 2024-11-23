package com.github.estebangmz666.service;

import com.github.estebangmz666.dao.UserDAO;
import com.github.estebangmz666.dto.UserDTO;
import com.github.estebangmz666.model.User;

import java.util.UUID;

public class UserService {

    private UserDAO userDAO;
    private EncryptionService encryptionService;
    

    public UserService() {
        this.userDAO = new UserDAO();
        this.encryptionService = new EncryptionService();
    }

    public boolean registerUser(UserDTO userDTO) {
        User user = new User(
            UUID.randomUUID(),
            userDTO.getEmail(),
            encryptionService.encryptPassword(userDTO.getPassword()),
            userDTO.getFullName(),
            userDTO.getDirection(),
            userDTO.getCellphone(),
            null,
            null
        );
        try {
            return userDAO.insertUser(user);
        } catch (Exception e) {
            throw new RuntimeException("Error al registrar el usuario", e);
        }
    }    
    

    public boolean emailExists(String email) {
        return userDAO.emailExists(email);
    }
}