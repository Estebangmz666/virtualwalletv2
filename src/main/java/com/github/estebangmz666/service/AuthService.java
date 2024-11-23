package com.github.estebangmz666.service;

import com.github.estebangmz666.dao.UserDAO;
import com.github.estebangmz666.dto.UserDTO;

public class AuthService {

    private UserDAO userDAO;
    
    public AuthService() {
        this.userDAO = new UserDAO();
        new EncryptionService();
    }

    public boolean validatePasswords(String password, String confirmPassword) {
        return password != null && password.equals(confirmPassword);
    }

    public boolean isEmailValid(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    public boolean isCellphoneValid(String cellphone) {
        return cellphone != null && cellphone.matches("\\d{10}");
    }

    public boolean isUserDataComplete(UserDTO userDTO) {
        return userDTO.getEmail() != null &&
               userDTO.getPassword() != null &&
               userDTO.getFullName() != null &&
               userDTO.getDirection() != null &&
               userDTO.getCellphone() != null;
    }

    public boolean emailExists(String email) {
        return userDAO.emailExists(email);
    }

    public String validateUserInput(UserDTO userDTO, String confirmPassword) {
        if (!isUserDataComplete(userDTO)) {
            return "Por favor, completa todos los campos.";
        }

        if (!validatePasswords(userDTO.getPassword(), confirmPassword)) {
            return "Las contraseñas no coinciden.";
        }

        if (!isEmailValid(userDTO.getEmail())) {
            return "El correo electrónico no es válido.";
        }

        if (!isCellphoneValid(userDTO.getCellphone())) {
            return "El número de teléfono no es válido. Debe tener 10 dígitos.";
        }

        if (emailExists(userDTO.getEmail())) {
            return "El correo ya está registrado.";
        }

        return null; 
    }
}