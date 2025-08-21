package app.service;

import java.util.List;

import app.dao.SQLAccess;

public class SQLService {

    private SQLAccess dao;

    public SQLService(SQLAccess dao) {
        this.dao = dao;
    }

    public String insertStudent(String[] name) {

        for (int i = 0; i < name.length; i++) {
            if (!name[i].matches("[a-zA-Z]+")) {
                // return error message
                return null;
            }
        }

        boolean daoResult = false;

        if (name.length == 3) {
            daoResult = this.dao.insertStudent(name[0], name[1], name[2]);
        } else {
            daoResult = this.dao.insertStudent(name[0], null, name[1]);
        }

        return null; // return success message
    }

    public String displayStudents() { // Displays student table contents
        List<String> students = null;
        students = this.dao.selectStudents();

        if (students == null) {
            // error!
        }

        StringBuilder output = new StringBuilder();

        for (String student : students) {
            output.append(student).append("\n");
        }

        return output.toString();
    }

}
