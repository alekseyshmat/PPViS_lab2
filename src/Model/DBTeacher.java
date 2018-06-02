package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DBTeacher {
    private List<Teacher> recordList;

    public DBTeacher() {
        recordList = new ArrayList<>();
    }

    public void addRecord(Teacher record) {
        recordList.add(record);
    }

    public List<Teacher> getRecordOfTeachers() {
        return recordList;
    }

    public void DataBase(List<Teacher> listData) {
        for (Teacher teacher : listData) {
            addRecord(teacher);
        }
    }

    public void deleteRecords() {
        recordList.clear();
    }

    public List<Teacher> firstSearch(JTextField second, JComboBox chair) {
        List<Teacher> searchList = new ArrayList<>();
        for (int i = 0; i < recordList.size(); i++) {
            boolean choose2 = second.getText().toLowerCase().equals(recordList.get(i).getSecondName().toLowerCase());
            boolean choose4 = chair.getSelectedItem().toString().toLowerCase().equals(recordList.get(i).getChair().toLowerCase());
            if (choose2 && choose4) {
                searchList.add(recordList.get(i));
            }
        }
        return searchList;
    }

    public List<Teacher> secondSearch(JComboBox academicTitle, JComboBox chair) {
        List<Teacher> searchList = new ArrayList<>();
        for (int i = 0; i < recordList.size(); i++) {
            boolean choose3 = academicTitle.getSelectedItem().toString().toLowerCase().equals(recordList.get(i).getAcademicTitle().toLowerCase());
            boolean choose4 = chair.getSelectedItem().toString().toLowerCase().equals(recordList.get(i).getChair().toLowerCase());
            if (choose3 && choose4) {
                searchList.add(recordList.get(i));
            }
        }
        return searchList;
    }

    public List<Teacher> thirdSearch(JComboBox academicTitle, JTextField from, JTextField to) {
        List<Teacher> searchList = new ArrayList<>();
        for (int i = 0; i < recordList.size(); i++) {
            boolean choose3 = academicTitle.getSelectedItem().toString().toLowerCase().equals(recordList.get(i).getAcademicTitle().toLowerCase());
            int work1 = Integer.parseInt(from.getText().toLowerCase());
            int work2 = Integer.parseInt(to.getText().toLowerCase());
            int work = recordList.get(i).getWorkExperience();
            boolean choose5 = false;
            if (work >= work1 && work <= work2)
                choose5 = true;
            if (choose3 && choose5) {
                searchList.add(recordList.get(i));
            }
        }
        return searchList;
    }

    public List<Teacher> forthSearch(JComboBox faculty, JComboBox chair) {
        List<Teacher> searchList = new ArrayList<>();
        for (int i = 0; i < recordList.size(); i++) {
            boolean choose1 = faculty.getSelectedItem().toString().toLowerCase().equals(recordList.get(i).getFaculty().toLowerCase());
            boolean choose4 = chair.getSelectedItem().toString().toLowerCase().equals(recordList.get(i).getChair().toLowerCase());
            if (choose1 && choose4) {
                searchList.add(recordList.get(i));
            }
        }
        return searchList;
    }

    public void deleteInSearch(List<Teacher> searchTeachers) {
        recordList.removeAll(searchTeachers);

    }
}
