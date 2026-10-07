package com.ty.scms.main;

import com.ty.scms.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Savepoint;

public class SavepointExample {

    public static void main(String[] args) {

        String sql =
                "INSERT INTO courses(id,name,credits) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            con.setAutoCommit(false);

            // First operation
            pstmt.setInt(1, 701);
            pstmt.setString(2, "Core Java");
            pstmt.setInt(3, 4);
            pstmt.executeUpdate();

            // Create savepoint
            Savepoint savepoint =
                    con.setSavepoint("COURSE_SAVEPOINT");

            try {

                // Second operation
                pstmt.setInt(1, 702);
                pstmt.setString(2, "JDBC");
                pstmt.setInt(3, 3);
                pstmt.executeUpdate();

                con.commit();

                System.out.println("Transaction committed successfully");

            } catch (Exception e) {

                con.rollback(savepoint);
                con.commit();

                System.out.println(
                        "Rolled back to savepoint successfully");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}