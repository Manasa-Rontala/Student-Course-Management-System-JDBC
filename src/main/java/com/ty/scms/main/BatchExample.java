package com.ty.scms.main;

import com.ty.scms.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BatchExample {

    public static void main(String[] args) {

        String sql =
                "INSERT INTO students(id,name,email,dob) VALUES(?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, 501);
            pstmt.setString(2, "Student One");
            pstmt.setString(3, "one@gmail.com");
            pstmt.setDate(4, java.sql.Date.valueOf("2000-01-10"));
            pstmt.addBatch();

            pstmt.setInt(1, 502);
            pstmt.setString(2, "Student Two");
            pstmt.setString(3, "two@gmail.com");
            pstmt.setDate(4, java.sql.Date.valueOf("2001-02-15"));
            pstmt.addBatch();

            pstmt.setInt(1, 503);
            pstmt.setString(2, "Student Three");
            pstmt.setString(3, "three@gmail.com");
            pstmt.setDate(4, java.sql.Date.valueOf("2002-03-20"));
            pstmt.addBatch();

            int[] results = pstmt.executeBatch();

            System.out.println(
                    "Batch executed. Records processed: "
                            + results.length
            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}