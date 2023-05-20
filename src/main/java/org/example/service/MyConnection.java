package org.example.service;

import java.sql.*;

public class MyConnection {

    private final static String DB_URL = "jdbc:postgresql://172.20.8.18/db0091_15";
    private final static String DB_USER = "st0091";
    private final static String DB_PASSWORD = "qwerty91";

    static Connection dbConnection = null;
    static Statement st;
    static ResultSet resultSet;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        dbConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        return dbConnection;
    }

    public ResultSet getResultSet(String query) throws SQLException {
        st = dbConnection.createStatement();
        resultSet = st.executeQuery(query);
        return resultSet;
    }
    public static void executeQuery(String query) throws SQLException {
        st = dbConnection.createStatement();
        st.executeQuery(query);
    }
}
