package com.ty.scms.main;

import com.ty.scms.util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();
        System.out.println("Connection established successfully");

        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
