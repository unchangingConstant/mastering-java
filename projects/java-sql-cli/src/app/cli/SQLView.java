package app.cli;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.NoSuchElementException;
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
            if (!execute(scnr.nextLine())) {
                return;
            }
        }
    }

    private boolean execute(String command) {
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
                        insertStudent(cmd.nextLine().trim());
                        break;
                    default:
                        // error message
                        break;
                }
                break;
            case "delete":
                switch (cmd.next()) {
                    case "student":
                        deleteStudent(cmd.nextLine().trim());
                        break;
                    default:
                        // error message
                        break;
                }
                break;
            case "q":
                return false;
            default:
                error(); // nah delyeet()
                break;
        }
        return true;
    }

    private void display() {

    }

    private void insertStudent(String params) {

        String[] name = params.split("\\s+");
        String result = null;

        // puts this logic in the service layer
        switch (name.length) {
            case 2:
                result = this.service.insertStudent(new String[] { name[0], name[1] });
                break;
            case 3:
                result = this.service.insertStudent(new String[] { name[0], name[1], name[2] });
                break;
            default:
                // write better error message
                result = "Invalid params";
                break;
        }

        this.out.println(result);
    }

    private void displayStudents() {
        List<String> students = this.service.displayStudents();
        this.out.println("STUDENTS IN TABLE:");
        for (int i = 0; i < students.size(); i++) {
            this.out.println(students.get(i));
        }
        this.out.print("END OF TABLE\n");
    }

    private void deleteStudent(String params) {
        throw new NoSuchElementException();
    }

    private void error() {

    }
}
