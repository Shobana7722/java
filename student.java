package com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class student extends DBCode {

    public int insert(int id, String name, String course, String doj, String department, String stream, int marks) throws SQLException {
        String query = "INSERT INTO student (id, name, course, dateofjoin, department, stream, marks) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, course);
            pst.setString(4, doj);
            pst.setString(5, department);
            pst.setString(6, stream);
            pst.setInt(7, marks);
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void select() throws SQLException {
        String query = "SELECT id, name, course, dateofjoin, department, stream, marks FROM student";
        try (PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
            System.out.println("ID\tNAME\tCOURSE\tDATE OF JOIN\tDEPARTMENT\tSTREAM\tMARKS");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String course = rs.getString("course");
                String dateofjoin = rs.getString("dateofjoin");
                String department = rs.getString("department");
                String stream = rs.getString("stream");
                int marks = rs.getInt("marks");
                System.out.println(id + "\t" + name + "\t" + course + "\t" + dateofjoin + "\t" + department + "\t" + stream + "\t" + marks);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int update(int id, String name, String course, String department, String stream, int marks) throws SQLException {
        String query = "UPDATE student SET course = ?, department = ?, stream = ?, marks = ? WHERE id = ? AND name = ?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, course);
            pst.setString(2, department);
            pst.setString(3, stream);
            pst.setInt(4, marks);
            pst.setInt(5, id);
            pst.setString(6, name);
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int delete(int id, String name) throws SQLException {
        String query = "DELETE FROM student WHERE id = ? AND name = ?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.setString(2, name);
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void selectByCourse(String course) throws SQLException {
        String query = "SELECT id, name, course, dateofjoin, department, stream, marks FROM student WHERE course = ?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, course);
            try (ResultSet rs = pst.executeQuery()) {
                System.out.println("ID\tNAME\tCOURSE\tDATE OF JOIN\tDEPARTMENT\tSTREAM\tMARKS");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String courseName = rs.getString("course");
                    String dateofjoin = rs.getString("dateofjoin");
                    String department = rs.getString("department");
                    String stream = rs.getString("stream");
                    int marks = rs.getInt("marks");
                    System.out.println(id + "\t" + name + "\t" + courseName + "\t" + dateofjoin + "\t" + department + "\t" + stream + "\t" + marks);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
