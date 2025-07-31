package app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Data access object handles all logic for SQL data management
 */
public class SQLAccess {

    // Database assumed to be located in root directory of repository
    private final String dbpath = "jdbc:sqlite:../../database.db";

    public SQLAccess() {

        try (Connection conn = DriverManager.getConnection(dbpath)) {
            if (conn != null) {
                System.out.println("Connection to SQLite has been established.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
