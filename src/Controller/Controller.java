package Controller;

import Model.Teacher;
import View.MainFrame;
import View.MainTable;
import Model.DBTeacher;

import javax.swing.*;
import java.util.List;

public class Controller {
    private MainTable mainTable;
    private DBTeacher db;
    private MainFrame mainFrame;

    public Controller(DBTeacher dbTeacher, MainTable mainTable, MainFrame mainFrame) {
        this.mainTable = mainTable;
        this.db = dbTeacher;
        this.mainFrame = mainFrame;
    }

    public MainTable getMainTable() {
        return mainTable;
    }

    public void addTeacher(Teacher teacher) {
        db.addRecord(teacher);
    }

    public void DataBase(List<Teacher> teachers) {
        db.DataBase(teachers);
    }

    public void clearData() {
        db.deleteRecords();
    }

    public void viewTeachers(MainTable mainTable, List<Teacher> teachers) {
        mainFrame.frame.add(mainTable.pagePanel);
        mainTable.startPage(teachers);
    }

    public List<Teacher> getListOfTeachers() {
        return db.getRecordOfTeachers();
    }

    public void created() {
        mainTable.create = true;
    }

    public List<Teacher> firstSearch(JTextField secondName, JComboBox chair) {
        return db.firstSearch(secondName, chair);
    }

    public List<Teacher> secondSearch(JComboBox title, JComboBox chair) {
        return db.secondSearch(title, chair);
    }

    public List<Teacher> thirdSearch(JComboBox title, JTextField from, JTextField to) {
        return db.thirdSearch(title, from, to);
    }

    public List<Teacher> forthSearch(JComboBox faculty, JComboBox chair) {
        return db.forthSearch(faculty, chair);
    }

    public void deleteInSearch(List<Teacher> searchTeachers) {
        db.deleteInSearch(searchTeachers);
    }
}
