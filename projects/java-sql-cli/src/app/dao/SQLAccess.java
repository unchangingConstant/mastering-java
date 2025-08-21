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
            conn.close();// necessary?
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(100);
        }
    }

    public boolean insertStudent(String firstName, String middleName, String lastName) {
        // executeQuery(String.format(null)); // no worky
        return false;
    }

    public List<String> selectStudents() {
        Connection conn = connection();
        ResultSet rs = executeQuery(conn, "SELECT * FROM students");
        ArrayList<String> students = new ArrayList<>();

        try {
            while (rs.next()) {
                students.add(String.format("%d %s %s %s", rs.getInt(1), rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
            // return null;
        }

        return students;
    }

    private Connection connection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(dbpath);
            /*
             * A result set cannot be accessed if a connection is closed.
             * TODO research this more in depth
             */
            // conn.close();
        } catch (SQLException e) {
            // TODO understand how connections and SQLExceptions work and write about them
            e.printStackTrace(System.err);
            System.err.println("SQLState: " +
                    e.getSQLState());
            System.err.println("Error Code: " +
                    e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            Throwable t = e.getCause();
            while (t != null) {
                System.out.println("Cause: " + t);
                t = t.getCause();
            }
        }

        return conn;
    }

    private ResultSet executeQuery(Connection conn, String query) {
        ResultSet rs = null;

        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            // TODO understand how connections and SQLExceptions work and write about them
            e.printStackTrace(System.err);
            System.err.println("SQLState: " +
                    e.getSQLState());
            System.err.println("Error Code: " +
                    e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            Throwable t = e.getCause();
            while (t != null) {
                System.out.println("Cause: " + t);
                t = t.getCause();
            }
        }

        return rs;
    }
}
