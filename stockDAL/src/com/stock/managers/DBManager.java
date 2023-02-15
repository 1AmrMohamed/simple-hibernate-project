package com.stock.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

    private final static String DB_NAME = "XE";
    private final static String SCHEMA_NAME = "stock";
    private final static String SCHEMA_PASSWORD = "stock";

    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("oracle.jdbc.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:" + DB_NAME, SCHEMA_NAME, SCHEMA_PASSWORD);
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn == null) {
            return;
        }

        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void closeStatement(PreparedStatement stmt) {
        if (stmt == null) {
            return;
        }
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs == null) {
            return;
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
