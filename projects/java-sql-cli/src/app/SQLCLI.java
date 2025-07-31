package app;

import app.dao.SQLAccess;

/**
 * Builds the app
 */
public class SQLCLI {
    /**
     * Builds SQLCLI application
     */
    public static void main(String[] args) {
        System.out.println("This application will succeed to open a SQLite database!");
        SQLAccess dao = new SQLAccess();
    }
}
