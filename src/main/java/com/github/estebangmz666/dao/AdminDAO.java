package com.github.estebangmz666.dao;

import com.github.estebangmz666.model.Admin;
import com.github.estebangmz666.model.NormalAdmin;
import com.github.estebangmz666.model.SuperAdmin;
import com.github.estebangmz666.model.AdminRole;
import com.github.estebangmz666.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AdminDAO {

    public boolean insertAdmin(Admin admin) {
        String sql = "INSERT INTO Admins (id, email, password, fullName, direction, cellphone, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, admin.getId().toString());
            pstmt.setString(2, admin.getEmail());
            pstmt.setString(3, admin.getPassword());
            pstmt.setString(4, admin.getFullName());
            pstmt.setString(5, admin.getDirection());
            pstmt.setString(6, admin.getCellphone());
            pstmt.setString(7, admin.getRole().toString());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Admin> getAllAdmins() {
        String sql = "SELECT * FROM Admins";
        List<Admin> admins = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Admin admin = createAdminFromResultSet(rs);
                if (admin != null) {
                    admins.add(admin);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    public Admin authenticateAdmin(String email, String password) {
        String sql = "SELECT * FROM Admins WHERE email = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return createAdminFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Admin createAdminFromResultSet(ResultSet rs) throws SQLException {
        UUID id = UUID.fromString(rs.getString("id"));
        String email = rs.getString("email");
        String password = rs.getString("password");
        String fullName = rs.getString("fullName");
        String direction = rs.getString("direction");
        String cellphone = rs.getString("cellphone");
        AdminRole role = AdminRole.valueOf(rs.getString("role"));

        switch (role) {
            case SUPERADMIN:
                return new SuperAdmin(id, email, password, fullName, direction, cellphone);
            case NORMALADMIN:
                return new NormalAdmin(id, email, password, fullName, direction, cellphone);
            default:
                return null;
        }
    }
}