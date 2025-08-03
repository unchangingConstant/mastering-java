package app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Data access object handles all logic for SQL data management
 */
public class SQLAccess {

    // Database assumed to be located in root directory of repository
    // Project assumed to be run from target dir
    private final String dbpath = "jdbc:sqlite:../database.db";

    public SQLAccess() {
        try (Connection conn = DriverManager.getConnection(dbpath)) {
            // Validates that database works and stuff
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean insert(String[] entry) {
        // Boolean indicates success or failure of insert
        return false;
    }

    public String[] deleteById(int id) {
        return null;
    }

    public String[] selectById(int id) {
        return null;
    }

    public String[][] selectAll() {
        return null;
    }

    public String[][] clear() {
        return null;
    }

    public String[] listTables() {
        return null;
    }

    // Is this possible?
    public Object tableSchema(String tableName) {
        return null;
    }

    private Connection connection() {
        try {
            return DriverManager.getConnection(dbpath);
        } catch (SQLException e) {
            throw new RuntimeException("Failure to connect to SQLite Databse, ", e);
        }
    }
}
