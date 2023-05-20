package org.example.dto.repository;

import org.example.dto.model.Avtor;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.*;

public class AvtorRepository {
    static Connection connection;
    private static Statement statement;
    public AvtorRepository(Connection con) {
        connection = con;
    }

    public static void createAvtor(Avtor avtor) throws SQLException {
        String query = String.format("INSERT INTO avtor (kod_avtor, fam, name, god_r, pol) " +
                "values ('%s', '%s', '%s', '%s', '%s')",
                avtor.getId(),
                avtor.getFam(),
                avtor.getName(),
                avtor.getGod_r(),
                avtor.getPol());
        statement = connection.createStatement();
        statement.execute(query);
        int affectedRows = statement.getUpdateCount();
        System.out.println(affectedRows);
    }

    public static void createAvtors(Map<Long,Avtor> avtors) throws SQLException {
        Statement statement = connection.createStatement();

        for(Map.Entry<Long, Avtor> avtor : avtors.entrySet()) {
            createAvtor(avtor.getValue());
        }
    }

    public List<Avtor> findAll() {
        List<Avtor> avtors = new ArrayList<>();

        try {
            statement = null;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM avtor");
            while (resultSet.next()) {
                Avtor avtor = new Avtor();
                avtor.setId(resultSet.getInt("kod_avtor"));
                avtor.setFam(resultSet.getString("fam"));
                avtor.setName(resultSet.getString("name"));
                avtor.setGod_r(resultSet.getInt("god_r"));
                avtor.setPol(resultSet.getString("pol"));

                avtors.add(avtor);
            }

            System.out.println(String.format("Кол-во найденных строк: ", avtors.size()));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return avtors;
    }

    public static List<Avtor> absolutPosition(int i) throws SQLException {
        List<Avtor> avtors = new ArrayList<>();

        Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM avtor");
        resultSet.absolute(i);
        resultSet.relative(1);

        Avtor avtor = new Avtor();
        resultSet.getInt("kod_avtor");
        resultSet.getString("fam");
        resultSet.getString("name");
        resultSet.getInt("god_r");
        resultSet.getString("pol");

        avtors.add(avtor);
        return avtors;
    }


}