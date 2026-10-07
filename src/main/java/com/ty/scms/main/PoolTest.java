package com.ty.scms.main;

import com.ty.scms.util.ConnectionPool;

import java.sql.Connection;

public class PoolTest {

    public static void main(String[] args) {

        try (Connection con =
                     ConnectionPool.getConnection()) {

            System.out.println(
                    "Connection obtained from pool successfully");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}