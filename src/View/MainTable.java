package View;

import Model.Teacher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainTable extends JTable {
    public static boolean create;
    private List<Teacher> teachers;
    private JTable table;
    private JScrollPane scrollPane;
    public JPanel pagePanel;

    private SearchFrame searchFrame;

    private int maxRecords;
    private int curPage;
    private int lastPage;

    private JButton nextButton;
    private JButton previousButton;
    private JButton lastButton;
    private JButton firstButton;

    private JLabel labelNumberOfRecords;
    private JLabel labelRecordsPage;
    private JTextField textRecordsPage;

    private DefaultTableModel tableModel;
    private String[] titles = {"ФИО", "Факультет", "Кафедра", "Ученое звание", "Ученая степень", "Стаж"};

    public MainTable() {
        create = false;
        startTable();
        mainPagePanel();

        ActionListener nextButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curPage++;
                viewPage(curPage, teachers);
                nextButton.setEnabled(true);
                previousButton.setEnabled(true);
                if (curPage == lastPage) {
                    nextButton.setEnabled(false);
                    lastButton.setEnabled(false);
                }
                if (curPage > 1)
                    firstButton.setEnabled(true);
            }
        };
        nextButton.addActionListener(nextButtonListener);

        ActionListener firstButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curPage = 1;
                viewPage(curPage, teachers);
                nextButton.setEnabled(true);
                lastButton.setEnabled(true);
                firstButton.setEnabled(false);
                previousButton.setEnabled(false);
            }
        };
        firstButton.addActionListener(firstButtonListener);

        ActionListener previousButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curPage--;
                viewPage(curPage, teachers);

                nextButton.setEnabled(true);
                previousButton.setEnabled(true);

                if (curPage == 1) {
                    nextButton.setEnabled(true);
                    lastButton.setEnabled(true);
                    previousButton.setEnabled(false);
                    firstButton.setEnabled(false);
                }
            }
        };
        previousButton.addActionListener(previousButtonListener);

        ActionListener lastButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curPage = lastPage;
                viewPage(lastPage, teachers);
                nextButton.setEnabled(false);
                lastButton.setEnabled(false);
                previousButton.setEnabled(true);
                firstButton.setEnabled(true);
            }
        };
        lastButton.addActionListener(lastButtonListener);

        ActionListener textRecordsPageListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int row = 0; row < maxRecords; row++) {
                    for (int column = 0; column < 6; column++) {
                        table.getModel().setValueAt("", row, column);
                    }
                }
                maxRecords = Integer.parseInt(textRecordsPage.getText());
                if (maxRecords <= 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "Введите больше 0");
                    textRecordsPage.setText(maxRecords + "");
                    return;
                }
                tableModel.setRowCount(maxRecords);
                curPage = 1;
                firstButton.setEnabled(false);
                previousButton.setEnabled(false);
                viewPage(1, teachers);
            }
        };
        textRecordsPage.addActionListener(textRecordsPageListener);
    }

    private void mainPagePanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        pagePanel = new JPanel();
        pagePanel.setLayout(new BoxLayout(pagePanel, BoxLayout.Y_AXIS));
        pagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelNumberOfRecords = new JLabel("Всего");
        labelRecordsPage = new JLabel("на странице");
        textRecordsPage = new JTextField("10");
        textRecordsPage.setPreferredSize(new Dimension(30, 30));

        textRecordsPage.setHorizontalAlignment(JTextField.CENTER);

        nextButton = new JButton("Следующая");
        nextButton.setEnabled(false);
        previousButton = new JButton("Предыдущая");
        previousButton.setEnabled(false);
        lastButton = new JButton("Последняя");
        lastButton.setEnabled(false);
        firstButton = new JButton("Первая");
        firstButton.setEnabled(false);

        buttonPanel.add(firstButton);
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(lastButton);
        buttonPanel.add(labelNumberOfRecords);
        buttonPanel.add(labelRecordsPage);
        buttonPanel.add(textRecordsPage);

        pagePanel.add(buttonPanel);
    }

    private void startTable() {
        maxRecords = 10;
        tableModel = new DefaultTableModel(maxRecords, titles.length);
        tableModel.setColumnIdentifiers(titles);

        table = new JTable(tableModel);

        scrollPane = new JScrollPane(table);
        table.setEnabled(false);

        TableColumn tableColumn0;
        tableColumn0 = table.getColumnModel().getColumn(0);
        tableColumn0.setMinWidth(120);

        TableColumn tableColumn1;
        tableColumn1 = table.getColumnModel().getColumn(1);
        tableColumn1.setMaxWidth(70);

        TableColumn tableColumn5;
        tableColumn5 = table.getColumnModel().getColumn(5);
        tableColumn5.setMaxWidth(50);

        curPage = 1;
        lastPage = 1;
    }

    private void viewPage(int page, List<Teacher> listOfTeachers) {
        int row = 0;
        pagePanel.add(scrollPane);
        teachers = listOfTeachers;

        if (teachers.size() % maxRecords == 0 && teachers.size() != 0) {
            lastPage = teachers.size() / maxRecords;
        } else {
            lastPage = teachers.size() / maxRecords + 1;
        }

        if (teachers.size() > maxRecords) {
            nextButton.setEnabled(true);
            lastButton.setEnabled(true);
        } else {
            firstButton.setEnabled(false);
            previousButton.setEnabled(false);
            lastButton.setEnabled(false);
            nextButton.setEnabled(false);
        }

        for (int index = (page - 1) * maxRecords; index < page * maxRecords;
             index++) {
            if (index < teachers.size()) {
                Teacher record = teachers.get(index);
                table.getModel().setValueAt(record.getName(), row, 0);
                table.getModel().setValueAt(record.getFaculty(), row, 1);
                table.getModel().setValueAt(record.getChair(), row, 2);
                table.getModel().setValueAt(record.getAcademicTitle(), row, 3);
                table.getModel().setValueAt(record.getAcademicDegree(), row, 4);
                table.getModel().setValueAt(record.getWorkExperience(), row, 5);

            } else {
                table.getModel().setValueAt("", row, 0);
                table.getModel().setValueAt("", row, 1);
                table.getModel().setValueAt("", row, 2);
                table.getModel().setValueAt("", row, 3);
                table.getModel().setValueAt("", row, 4);
                table.getModel().setValueAt("", row, 5);
            }
            row++;
        }
        labelNumberOfRecords.setText("Записей всего: " + teachers.size());
        labelRecordsPage.setText("Страница: " + curPage + " из " + lastPage);

        pagePanel.repaint();
    }

    public void startPage(List<Teacher> teachers) {
        curPage = 1;
        viewPage(1, teachers);
    }
}
