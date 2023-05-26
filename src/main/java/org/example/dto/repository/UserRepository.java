package org.example.dto.repository;

import java.sql.Connection;
import java.sql.Statement;

public class UserRepository {
    static Connection connection;
    private static Statement statement;
    public UserRepository(Connection con) {
        connection = con;
    }


}
