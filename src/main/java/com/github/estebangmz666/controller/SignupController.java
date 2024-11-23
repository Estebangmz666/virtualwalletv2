package com.github.estebangmz666.controller;

import com.github.estebangmz666.dto.UserDTO;
import com.github.estebangmz666.service.AuthService;
import com.github.estebangmz666.service.UserService;
import com.github.estebangmz666.util.ViewLoader;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignupController implements ViewLoader {

    @Override
    public void loadView(ActionEvent event, String view) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(view));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            lbMessage.setText("Error cargando la vista: " + view);
            e.printStackTrace();
        }
    }

    @FXML
    private Button btnSignup;

    @FXML
    private Hyperlink hlGoToLogin;

    @FXML
    private Label lbMessage;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfDirection;

    @FXML
    private TextField tfCellphone;

    @FXML
    private TextField tfPassword;

    @FXML
    private TextField tfConfirmPassword;

    private AuthService authService = new AuthService();
    private UserService userService = new UserService();

    @FXML
    void btnSignupClicked(ActionEvent event) {
        String name = tfName.getText().trim();
        String email = tfEmail.getText().trim();
        String direction = tfDirection.getText().trim();
        String cellphone = tfCellphone.getText().trim();
        String password = tfPassword.getText();
        String confirmPassword = tfConfirmPassword.getText();

        UserDTO userDTO = new UserDTO(email, password, name, direction, cellphone);

        String validationError = authService.validateUserInput(userDTO, confirmPassword);
        if (validationError != null) {
            lbMessage.setText(validationError);
            return;
        }

        if (userService.registerUser(userDTO)) {
            lbMessage.setText("¡Usuario registrado exitosamente!");
            clearFields();
            navigateToLogin(event);
        } else {
            lbMessage.setText("Error al registrar el usuario. Inténtalo de nuevo.");
        }
    }

    @FXML
    void hlGoToLoginClicked(ActionEvent event) {
        navigateToLogin(event);
    }

    private void navigateToLogin(ActionEvent event) {
        loadView(event, "/view/Login.fxml");
    }

    private void clearFields() {
        tfName.clear();
        tfEmail.clear();
        tfDirection.clear();
        tfCellphone.clear();
        tfPassword.clear();
        tfConfirmPassword.clear();
    }
}