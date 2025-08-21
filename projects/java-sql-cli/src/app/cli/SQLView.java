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
        this.in = in;
    }

    public void run() {
        boolean running = true;
        Scanner scnr = new Scanner(this.in);

        while (running) {
            this.out.print("Enter next command: ");
            execute(scnr.nextLine());
        }

    }

    private void execute(String command) {
        Scanner cmd = new Scanner(command);
        switch (cmd.next()) {
            case "display": // add display student's visits, student list
                switch (cmd.next()) {
                    case "students":
                        displayStudents();
                        break;
                    default:
                        break;
                }
                break;
            case "insert":
                switch (cmd.next()) {
                    case "student":
                        // insertStudent(cmd.nextLine());
                        break;
                    default:
                        break;
                }
                break;
            case "delete":
                delete();
                break;
            default:
                error();
                break;
        }
    }

    private void display() {

    }

    private void insertStudent(String params) {

        String[] name = params.split("\\s+");

        switch (name.length) {
            case 2:
                this.service.insertStudent(new String[] { name[0], name[1] });
                break;
            case 3:
                this.service.insertStudent(new String[] { name[0], name[1], name[2] });
                break;
            default:
                // command error message
                break;
        }
    }

    private void displayStudents() {
        this.out.println("STUDENTS IN TABLE:");
        this.out.println(this.service.displayStudents());
        this.out.print("END OF TABLE\n");
    }

    private void delete() {

    }

    private void error() {

    }

}
