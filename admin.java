package com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class admin extends DBCode {

    
    public int insert(String username, String password) throws SQLException {
        String query = "INSERT INTO admin (username, password) VALUES (?, ?)";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, username);
            pst.setString(2, password);
            return pst.executeUpdate(); 
        }
    }

    
    public void select() throws SQLException {
        String query = "SELECT * FROM admin";
        try (PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                System.out.println("Username: " + rs.getString("username") + 
                                   ", Password: " + rs.getString("password"));
            }
        }
    }

    
    public boolean search(String username, String password) throws SQLException {
        String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, username);
            pst.setString(2, password);
            try (ResultSet rs = pst.executeQuery()) {
                return rs.next(); 
            }
        }
    }
}

