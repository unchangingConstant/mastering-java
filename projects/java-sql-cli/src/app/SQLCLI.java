package app;

import app.cli.SQLView;
import app.dao.SQLAccess;
import app.service.SQLService;

/**
 * Builds the app
 */
public class SQLCLI {
    /**
     * Builds SQLCLI application
     */
    public static void main(String[] args) {
        System.out.println("This application will succeed to open a SQLite database!");

        SQLAccess dao = new SQLAccess(args[0]);
        SQLService svc = new SQLService(dao);
        SQLView view = new SQLView(svc, System.out, System.in);

        view.run();

    }
}
