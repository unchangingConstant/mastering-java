package app.service;

import java.util.List;

import app.dao.SQLAccess;

// Mostly in charge of complex data validation
public class SQLService {

    private SQLAccess dao;

    public SQLService(SQLAccess dao) {
        this.dao = dao;
    }

    public String insertStudent(String[] name) {

        for (int i = 0; i < name.length; i++) {
            if (!name[i].matches("[a-zA-Z]+")) {
                return "Please use alphabetical characters.";
            }
        }

        boolean daoResult = false;

        if (name.length == 3) {
            this.dao.insertStudent(name[0], name[1], name[2]);
        } else {
            this.dao.insertStudent(name[0], null, name[1]);
        }

        return "Insert successful!";
    }

    public List<String> displayStudents() { // Displays student table contents
        return this.dao.selectStudents();
    }

    public String deleteStudent(String name) {
        return null;
    }

}
