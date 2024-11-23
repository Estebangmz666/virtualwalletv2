package com.github.estebangmz666.util;

import com.github.estebangmz666.model.User;
import com.github.estebangmz666.model.Admin;

public class SessionManager {

    private static SessionManager instance;
    private User currentUser;
    private Admin currentAdmin;

    private SessionManager() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
        this.currentAdmin = null;
    }

    public Admin getCurrentAdmin() {
        return currentAdmin;
    }

    public void setCurrentAdmin(Admin admin) {
        this.currentAdmin = admin;
        this.currentUser = null;
    }

    public void clearSession() {
        this.currentUser = null;
        this.currentAdmin = null;
    }
}