package com.ty.scms.main;

import com.ty.scms.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {

    public static void main(String[] args) {

        String sql =
                "INSERT INTO courses(id,name,credits) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection()) {

            con.setAutoCommit(false);

            try (PreparedStatement pstmt = con.prepareStatement(sql)) {

                pstmt.setInt(1, 601);
                pstmt.setString(2, "Spring");
                pstmt.setInt(3, 4);

                pstmt.executeUpdate();

                con.commit();

                System.out.println("Transaction committed successfully");

            } catch (Exception e) {

                con.rollback();

                System.out.println("Transaction rolled back");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}