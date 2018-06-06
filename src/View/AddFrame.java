package View;

import Controller.Controller;
import Model.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AddFrame {
    public JFrame frame = new JFrame();

    private JTextField textFirstName;
    private JTextField textSecondName;
    private JTextField textThirdName;
    private JComboBox faculty;
    private JComboBox academicDegree;
    private JComboBox academicTitle;
    private JComboBox chair;
    private JTextField textWorkExperience;

    public static String[] facultyItems = {
            "ФИТиУ",
            "ФКСиС",
            "ИЭФ",
            "ФРЭ",
            "ФИК",
            "ВФ",
            "ФКП"
    };

    public static String[] academicTitleItems = {
            "профессор",
            "доцент",
            "ассистент",
            "преподаватель",
            "начальник цикла"
    };

    private static String[] academicDeagreeItems = {
            "отсутсвует",
            "доктор техн. наук",
            "кандидат техн. наук",
            "кандидат физ.-матем. наук",
            "кандидат истор. наук",
            "кандидат фил. наук",
            "кандидат военных наук"
    };

    private static String[] fituChairItems = {
            "ВМиП",
            "гуманитарных дисциплин",
            "ИИТ",
            "ИТАС",
            "СУ",
            "ТОЭ"
    };

    private static String[] fksisChairItems = {
            "высшей математики",
            "информатики",
            "ПОИТ",
            "Физики",
            "философии",
            "ЭВМ",
            "ЭВС"
    };

    private static String[] fkpChairItems = {
            "ИиКГ",
            "ИПиЭ",
            "ИЯ1",
            "ПИКС",
            "ЭТиТ"
    };

    private static String[] iefChairItems = {
            "ЭИ",
            "экономики",
            "менеджмента",
            "ИЯ2"
    };

    private static String[] freChairItems = {
            "электроники",
            "ИР",
            "МиНЭ"
    };

    private static String[] fikChairItems = {
            "защиты информации",
            "ИТ",
            "физвоспитания"
    };

    private static String[] vfChairItems = {
            "связи",
            "тактики",
            "РЭТ ВВС"
    };

    public static String[] chairs[] = {
            fituChairItems,
            fksisChairItems,
            iefChairItems,
            freChairItems,
            fikChairItems,
            vfChairItems,
            fkpChairItems
    };

    private Controller controller;

    public AddFrame(Controller controller) {
        this.controller = controller;

        frame.setTitle("Добавление преподавателя");
        frame.setSize(new Dimension(450, 450));
        frame.setResizable(false);
        frame.setLocation(200, 200);

        JButton addButton = new JButton("Добавить");
        JButton cancelButton = new JButton("Отмена");
        JButton clearButton = new JButton("Очистить");

        ActionListener addButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addTeacher(readTeacher());
                MainTable mainTable = controller.getMainTable();
                mainTable.startPage(controller.getListOfTeachers());
                frame.setVisible(false);
                clearFields();
            }
        };
        addButton.addActionListener(addButtonListener);
        ActionListener cancelButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                clearFields();
            }
        };
        cancelButton.addActionListener(cancelButtonListener);
        ActionListener clearButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        };
        clearButton.addActionListener(clearButtonListener);


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(setNamePanel());
        panel.add(setButtons(addButton, cancelButton, clearButton));

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
        JPanel panelCon = new JPanel();
        panelCon.setLayout(new BoxLayout(panelCon, BoxLayout.Y_AXIS));

        JLabel labelSecondName = new JLabel("Фамилия:");
        textSecondName = new JTextField();
        labelSecondName.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel labelFirstName = new JLabel("Имя:");
        labelFirstName.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFirstName = new JTextField();

        JLabel labelThirdName = new JLabel("Отчество:");
        textThirdName = new JTextField();

        JLabel labelFaculty = new JLabel("Факультет:");
        faculty = new JComboBox(facultyItems);
        faculty.setSelectedIndex(-1);

        JLabel labelChair = new JLabel("Кафедра:");
        chair = new JComboBox();
        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    chair.setModel(new DefaultComboBoxModel(chairs[faculty.getSelectedIndex()]));
                }
            }
        };
        faculty.addItemListener(itemListener);

        JLabel labelAcademicTitle = new JLabel("Ученое звание:");
        academicTitle = new JComboBox(academicTitleItems);
        academicTitle.setSelectedIndex(-1);

        JLabel labelAcademicDegree = new JLabel("Ученая степень:");
        academicDegree = new JComboBox(academicDeagreeItems);
        academicDegree.setSelectedIndex(0);

        JLabel labelWorkExperience = new JLabel("Стаж работы:");
        textWorkExperience = new JTextField();

        panelCon.add(labelSecondName);
        panelCon.add(textSecondName);
        panelCon.add(labelFirstName);
        panelCon.add(textFirstName);
        panelCon.add(labelThirdName);
        panelCon.add(textThirdName);
        panelCon.add(labelFaculty);
        panelCon.add(faculty);
        panelCon.add(labelChair);
        panelCon.add(chair);
        panelCon.add(labelAcademicTitle);
        panelCon.add(academicTitle);
        panelCon.add(labelAcademicDegree);
        panelCon.add(academicDegree);
        panelCon.add(labelWorkExperience);
        panelCon.add(textWorkExperience);

        return panelCon;
    }

    private Teacher readTeacher() {
        Teacher teacher = new Teacher();
        teacher.setFirstName(textFirstName.getText());
        teacher.setSecondName(textSecondName.getText());
        teacher.setThirdName(textThirdName.getText());
        teacher.setFaculty(faculty.getSelectedItem().toString());
        teacher.setChair(chair.getSelectedItem().toString());
        teacher.setAcademicTitle(academicTitle.getSelectedItem().toString());
        teacher.setAcademicDegree(academicDegree.getSelectedItem().toString());
        teacher.setWorkExperience(Integer.parseInt(textWorkExperience.getText()));

        return teacher;
    }

    private void clearFields() {
        textFirstName.setText("");
        textSecondName.setText("");
        textThirdName.setText("");
        faculty.setSelectedIndex(-1);
        academicTitle.setSelectedIndex(-1);
        academicDegree.setSelectedIndex(-1);
        chair.setSelectedIndex(-1);
        textWorkExperience.setText("");
    }
}
