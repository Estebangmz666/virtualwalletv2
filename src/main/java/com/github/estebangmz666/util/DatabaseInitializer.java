package com.github.estebangmz666.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseInitializer {

    private static final String DB_URL = "jdbc:sqlite:virtual_wallet.db";

    public static void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {

            String createUsersTable = """
                CREATE TABLE IF NOT EXISTS Users (
                    id TEXT PRIMARY KEY,
                    email TEXT NOT NULL,
                    password TEXT NOT NULL,
                    fullName TEXT NOT NULL,
                    direction TEXT,
                    cellphone TEXT
                );
            """;

            String createAdminsTable = """
                CREATE TABLE IF NOT EXISTS Admins (
                    id TEXT PRIMARY KEY,
                    email TEXT NOT NULL,
                    password TEXT NOT NULL,
                    fullName TEXT NOT NULL,
                    direction TEXT,
                    cellphone TEXT,
                    role TEXT NOT NULL
                );
            """;

            statement.execute(createUsersTable);
            System.out.println("Tabla 'Users' creada o ya existe.");

            statement.execute(createAdminsTable);
            System.out.println("Tabla 'Admins' creada o ya existe.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}