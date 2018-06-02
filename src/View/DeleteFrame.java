package View;

import Controller.Controller;
import Model.DBTeacher;
import Model.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DeleteFrame {
    public JFrame frame = new JFrame();
    private DBTeacher dbTeacher;
    private Controller controller;
    private List<Teacher> searchList;

    private JTextField textSecondName;
    private JTextField textFromWorkExperience;
    private JTextField textToWorkExperience;

    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JComboBox academicTitle;
    private JComboBox chair;
    private JComboBox faculty;

    public DeleteFrame(Controller controller) {
        this.controller = controller;

        frame.setTitle("Удаление");
        frame.setSize(new Dimension(450, 400));
        frame.setResizable(false);
        frame.setLocation(200, 200);

        JButton deleteButton = new JButton("Удалить");
        JButton cancelButton = new JButton("Отмена");
        JButton clearButton = new JButton("Очистить");

        radioButton1 = new JRadioButton("Удаление по фамилии и кафедре");
        radioButton2 = new JRadioButton("Удаление по ученому званию и кафедре");
        radioButton3 = new JRadioButton("Удаление по стажу работы и ученому званию");
        radioButton4 = new JRadioButton("Удаление по факультету и кафедре");

        ActionListener searchButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainTable mainTable = controller.getMainTable();
                if (radioButton1.isSelected()) {
                    searchList = controller.firstSearch(textSecondName, chair);
                    if (searchList.size() == 0) {
                        JOptionPane.showMessageDialog(new JFrame(), "Ничего не найдено");
                        clearFields();
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Удалено "+searchList.size()+ " записей");
                        controller.deleteInSearch(searchList);
                        mainTable.startPage(controller.getListOfTeachers());
                        clearFields();
                        frame.setVisible(false);
                    }
                }
                if (radioButton2.isSelected()) {
                    searchList = controller.secondSearch(academicTitle, chair);
                    if (searchList.size() == 0) {
                        JOptionPane.showMessageDialog(new JFrame(), "Ничего не найдено");
                        clearFields();
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Удалено "+searchList.size()+ " записей");
                        controller.deleteInSearch(searchList);
                        mainTable.startPage(controller.getListOfTeachers());
                        clearFields();
                        frame.setVisible(false);
                    }
                }
                if (radioButton3.isSelected()) {
                    searchList = controller.thirdSearch(academicTitle, textFromWorkExperience, textToWorkExperience);
                    if (searchList.size() == 0) {
                        JOptionPane.showMessageDialog(new JFrame(), "Ничего не найдено");
                        clearFields();
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Удалено "+searchList.size()+ " записей");
                        controller.deleteInSearch(searchList);
                        mainTable.startPage(controller.getListOfTeachers());
                        clearFields();
                        frame.setVisible(false);
                    }
                }
                if (radioButton4.isSelected()) {
                    searchList = controller.forthSearch(faculty, chair);
                    if (searchList.size() == 0) {
                        JOptionPane.showMessageDialog(new JFrame(), "Ничего не найдено");
                        clearFields();
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Удалено "+searchList.size()+ " записей");
                        controller.deleteInSearch(searchList);
                        mainTable.startPage(controller.getListOfTeachers());
                        clearFields();
                        frame.setVisible(false);
                    }
                }
            }
        };
        deleteButton.addActionListener(searchButtonListener);

        ActionListener cancelButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        };
        cancelButton.addActionListener(cancelButtonListener);

        ActionListener clearActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        };
        clearButton.addActionListener(clearActionListener);

        ActionListener radioButtonListener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
                textSecondName.setEditable(true);
                chair.setEnabled(true);
                faculty.setEnabled(false);
                academicTitle.setEnabled(false);
                textFromWorkExperience.setEditable(false);
                textToWorkExperience.setEditable(false);
            }
        };
        radioButton1.addActionListener(radioButtonListener1);

        ActionListener radioButtonListener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
                textSecondName.setEditable(false);
                chair.setEnabled(true);
                faculty.setEnabled(false);
                academicTitle.setEnabled(true);
                textFromWorkExperience.setEditable(false);
                textToWorkExperience.setEditable(false);
            }
        };
        radioButton2.addActionListener(radioButtonListener2);

        ActionListener radioButtonListener3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
                textSecondName.setEditable(false);
                chair.setEnabled(false);
                faculty.setEnabled(false);
                academicTitle.setEnabled(true);
                textFromWorkExperience.setEditable(true);
                textToWorkExperience.setEditable(true);
            }
        };
        radioButton3.addActionListener(radioButtonListener3);

        ActionListener radioButtonListener4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
                textSecondName.setEditable(false);
                chair.setEnabled(true);
                faculty.setEnabled(true);
                academicTitle.setEnabled(false);
                textFromWorkExperience.setEditable(false);
                textToWorkExperience.setEditable(false);
            }
        };
        radioButton4.addActionListener(radioButtonListener4);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(setNamePanel());
        panel.add(setButtons(deleteButton, cancelButton, clearButton));
        frame.add(panel);
    }

    private JPanel setButtons(JButton button1, JButton button2, JButton button3) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        return buttonPanel;
    }

    private JPanel setNamePanel() {

        JPanel searchPanel = new JPanel();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);
        buttonGroup.add(radioButton4);

        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));

        searchPanel.add(radioButton1);
        searchPanel.add(radioButton2);
        searchPanel.add(radioButton3);
        searchPanel.add(radioButton4);

        searchPanel.add(new JLabel("Фамилия:"));
        textSecondName = new JTextField();
        searchPanel.add(textSecondName);

        searchPanel.add(new JLabel("Факультет:"));
        faculty = new JComboBox(AddFrame.facultyItems);
        faculty.setSelectedIndex(-1);
        searchPanel.add(faculty);

        searchPanel.add(new JLabel("Кафедра:"));
        chair = new JComboBox(SearchFrame.allChairItems);
        chair.setSelectedIndex(-1);
        searchPanel.add(chair);

        searchPanel.add(new JLabel("Звание:"));
        academicTitle = new JComboBox(AddFrame.academicTitleItems);
        academicTitle.setSelectedIndex(-1);
        searchPanel.add(academicTitle);


        searchPanel.add(setWorkExperience());

        return searchPanel;
    }

    private JPanel setWorkExperience() {
        JPanel workPanel = new JPanel();
        workPanel.setLayout(new FlowLayout());
        workPanel.add(new JLabel("Стаж работы:"));
        workPanel.add(new JLabel("от:"));
        textFromWorkExperience = new JTextField("", 5);
        workPanel.add(textFromWorkExperience);

        workPanel.add(new JLabel("до:"));
        textToWorkExperience = new JTextField("", 5);
        workPanel.add(textToWorkExperience);

        return workPanel;
    }

    private void clearFields() {
        textSecondName.setText("");
        faculty.setSelectedIndex(-1);
        academicTitle.setSelectedIndex(-1);
        chair.setSelectedIndex(-1);
        textFromWorkExperience.setText("");
        textToWorkExperience.setText("");
    }
}
