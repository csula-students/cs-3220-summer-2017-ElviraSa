package edu.csula.jaxrs;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;


public class Database {
    public static final String database = "cs3220xstu17";
    public static final String url = "jdbc:mysql://cs3.calstatela.edu/" + database;
    public static final String username = "cs3220xstu17";
    public static final String password = "P!X!6rtz";

    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch( ClassNotFoundException e ) {
            throw new IllegalStateException(e);
        }
    }

    public Connection connection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
