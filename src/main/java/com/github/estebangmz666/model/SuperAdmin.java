package com.github.estebangmz666.model;

import java.util.UUID;

public class SuperAdmin extends Admin {
    public SuperAdmin(UUID id, String email, String password, String fullName, String direction, String cellphone) {
        super(id, email, password, fullName, direction, cellphone, AdminRole.SUPERADMIN);
    }

    public NormalAdmin createNormalAdmin(String email, String password, String fullName, String direction, String cellphone) {
        return new NormalAdmin(UUID.randomUUID(), email, password, fullName, direction, cellphone);
    }
}