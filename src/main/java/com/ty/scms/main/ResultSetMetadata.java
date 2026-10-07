package com.ty.scms.main;

import com.ty.scms.util.DBConnection;

import java.sql.*;

public class ResultSetMetadata {

    public static void main(String[] args) {

        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData metaData =
                    rs.getMetaData();

            int columnCount =
                    metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {

                System.out.println(
                        i + " : " +
                                metaData.getColumnName(i) +
                                " : " +
                                metaData.getColumnTypeName(i)
                );
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}