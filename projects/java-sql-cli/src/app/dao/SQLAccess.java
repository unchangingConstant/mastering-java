package app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access object handles all logic for SQL data management
 */
public class SQLAccess {

    // Database assumed to be located in root directory of repository
    // Project assumed to be run from target dir
    private final String dbpath;

    public SQLAccess(String dbpath) {
        this.dbpath = String.format("jdbc:sqlite:%s", dbpath);
        try (Connection conn = DriverManager.getConnection(this.dbpath)) {
            // Validates that database works and stuff
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(100);
        }
    }

    public boolean insertStudent(String firstName, String middleName, String lastName) {
        executeQuery(String.format(null)); // no worky
        return false;
    }

    public List<String> selectStudents() {
        ResultSet rs = executeQuery(String.format("SELECT * FROM students"));
        ArrayList<String> students = new ArrayList<>();

        try {
            rs.next();
            System.out.println(rs.getString(1));
            // while (rs.next()) {
            // students.add(String.format("%d %s %s %s", rs.getInt(0), rs.getString(1),
            // rs.getString(2),
            // rs.getString(3)));
            // }
        } catch (SQLException e) {
            return null;
        }

        return students;
    }

    private ResultSet executeQuery(String query) {
        Connection conn;
        ResultSet result = null;

        try {
            conn = DriverManager.getConnection(dbpath);
        } catch (SQLException e) {
            System.out.println(e);
            System.exit(101);
        }

        try {
            conn = DriverManager.getConnection(dbpath);
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery(query);
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQLAccess.executeQuery() execution failure");
            System.exit(102);
        }

        return result;
    }
}
