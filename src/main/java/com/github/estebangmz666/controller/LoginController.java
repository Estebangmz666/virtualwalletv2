package com.github.estebangmz666.controller;

import com.github.estebangmz666.dao.AdminDAO;
import com.github.estebangmz666.dao.UserDAO;
import com.github.estebangmz666.model.Admin;
import com.github.estebangmz666.model.User;
import com.github.estebangmz666.util.SessionManager;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements ViewLoader {

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
    private Button btnLogin;

    @FXML
    private Hyperlink hlSignup;

    @FXML
    private Label lbMessage;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private TextField tfEmail;

    private UserDAO userDAO = new UserDAO();
    private AdminDAO adminDAO = new AdminDAO();

    @FXML
    void btnLoginClicked(ActionEvent event) {
        String email = tfEmail.getText().trim();
        String password = pfPassword.getText().trim();

        if (email.isEmpty()) {
            lbMessage.setText("Por favor, ingresa tu correo electrónico.");
            return;
        }

        if (password.isEmpty()) {
            lbMessage.setText("Por favor, ingresa tu contraseña.");
            return;
        }

        User user = userDAO.authenticateUser(email, password);
        if (user != null) {
            SessionManager.getInstance().setCurrentUser(user);
            lbMessage.setText("Inicio de sesión exitoso como usuario.");
            navigateToUserDashboard(event);
            return;
        }

        Admin admin = adminDAO.authenticateAdmin(email, password);
        if (admin != null) {
            SessionManager.getInstance().setCurrentAdmin(admin);
            lbMessage.setText("Inicio de sesión exitoso como administrador.");
            navigateToAdminDashboard(event);
            return;
        }

        lbMessage.setText("Correo o contraseña incorrectos.");
        clearFields();
    }

    @FXML
    void hlSignupClicked(ActionEvent event) {
        navigateToSignup(event);
    }

    private void navigateToUserDashboard(ActionEvent event) {
        loadView(event, "/view/UserDashboard.fxml");
    }

    private void navigateToAdminDashboard(ActionEvent event) {
        loadView(event, "/view/AdminDashboard.fxml");
    }

    private void navigateToSignup(ActionEvent event) {
        loadView(event, "/view/Signup.fxml");
    }

    private void clearFields() {
        tfEmail.clear();
        pfPassword.clear();
    }
}