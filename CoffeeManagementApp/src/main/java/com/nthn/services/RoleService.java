/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nthn.services;

import com.nthn.configs.JdbcUtils;
import com.nthn.pojo.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HONGNHAT
 */
public class RoleService {

//    public List<String> getRoles() throws SQLException, ClassNotFoundException {
//        List<String> roles = new ArrayList<>();
//        try (Connection c = JdbcUtils.getConnection()) {
//            Statement s = c.createStatement();
//            ResultSet rs = s.executeQuery("SELECT * FROM roles");
//            while (rs.next()) {
//                roles.add(rs.getString("RoleName"));
//            }
//        }
//        return roles;
//    }
    public List<Role> getRoles() throws SQLException, ClassNotFoundException {
        List<Role> roles = new ArrayList<>();
        try (Connection c = JdbcUtils.getConnection()) {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM roles");
            while (rs.next()) {
                roles.add(Role.getRoleByID(rs.getInt("RoleID")));
            }
        }
        return roles;
    }

    public void addRole(Role role) {
        try (Connection connection = JdbcUtils.getConnection()) {
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO roles(RoleID, RoleName) VALUES(?,?)");
            preparedStatement.setInt(1, role.getRoleID());
            preparedStatement.setString(2, role.getRoleName());

            preparedStatement.executeUpdate();

            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(RoleService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getRole(int id) throws SQLException {
        try (Connection c = JdbcUtils.getConnection()) {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT RoleName FROM roles WHERE RoleID=" + id);
            while (rs.next()) {
                return rs.getString("RoleName");
            }
        }
        return null;
    }

    public int getRole(String text) throws SQLException {
        try (Connection c = JdbcUtils.getConnection()) {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT RoleName FROM roles WHERE RoleName=" + text);
            while (rs.next()) {
                return rs.getInt("RoleID");
            }
        }
        return 0;
    }
}
