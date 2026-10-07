package com.ty.scms.main;

import com.ty.scms.util.DBConnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

public class DatabaseMetadata {

    public static void main(String[] args) {

        try (Connection con = DBConnection.getConnection()) {

            DatabaseMetaData metaData =
                    con.getMetaData();

            System.out.println(
                    "Database: " +
                            metaData.getDatabaseProductName()
            );

            System.out.println(
                    "Version: " +
                            metaData.getDatabaseProductVersion()
            );

            System.out.println(
                    "Driver: " +
                            metaData.getDriverName()
            );

            System.out.println(
                    "Driver Version: " +
                            metaData.getDriverVersion()
            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}