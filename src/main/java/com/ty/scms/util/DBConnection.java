package com.ty.scms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {

        String url = "jdbc:postgresql://localhost:5432/student_db2";

        String username = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");

        try {
            Class.forName("org.postgresql.Driver");

            Connection con =
                    DriverManager.getConnection(url, username, password);

            System.out.println("Database Connected Successfully");

            return con;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}