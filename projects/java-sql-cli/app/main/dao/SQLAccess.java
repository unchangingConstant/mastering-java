package app.main.dao;

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

    /**
     * Verifies that the database has the expected schema:
     * 
     * STUDENTS
     * id INTEGER PRIMARY KEY AUTOINCREMENT
     * name TEXT NOT NULL
     * 
     * VISITS
     * id INTEGER PRIMARY KEY AUTOINCREMENT
     * studentId INTEGER FOREIGN KEY
     * inTime TEXT NOT NULL
     * outTime TEXT
     * 
     * TODO: IMPLEMENT!
     */
    private void verifyDatabase() {
        return;
    }

}
