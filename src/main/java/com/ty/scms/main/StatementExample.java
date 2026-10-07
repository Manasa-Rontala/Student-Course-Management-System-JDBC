package com.ty.scms.main;

import com.ty.scms.util.DBConnection;

import java.sql.*;

public class StatementExample {

    public static void main(String[] args) {

        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("email")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}