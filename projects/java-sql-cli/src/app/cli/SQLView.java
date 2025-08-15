package app.cli;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import app.service.*;

/**
 * ROLE: Presentation layer for viewer, also gives user access to the controller
 * through the interface
 */
public class SQLView {

    private SQLService service;
    private PrintStream out;
    private InputStream in;

    public SQLView(SQLService service, OutputStream out, InputStream in) {
        if (out == null || service == null || in == null) {
            throw new IllegalStateException("Arguments for SQLView() can't be null");
        }
        this.service = service;
        this.out = new PrintStream(out);
    }

    public void run() {
        Scanner scnr = new Scanner(this.in);

        while (true) {
            execute(scnr.nextLine());
        }
    }

    private void execute(String command) {
        Scanner cmd = new Scanner(command);
        switch (cmd.next()) {
            case "display":
                display();
                break;
            case "insert":
                insert(cmd.next());
                break;
            default:
                error();
                break;
        }
    }

    private void display() {

    }

    private void insert(String sample) {

    }

    private void error() {

    }

    private boolean valid(String command) {
        return false;
    }

}
