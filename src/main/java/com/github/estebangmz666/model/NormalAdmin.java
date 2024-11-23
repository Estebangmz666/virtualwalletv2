package com.github.estebangmz666.model;

import java.util.UUID;

public class NormalAdmin extends Admin {
    public NormalAdmin(UUID id, String email, String password, String fullName, String direction, String cellphone) {
        super(id, email, password, fullName, direction, cellphone, AdminRole.NORMALADMIN);
    }
}