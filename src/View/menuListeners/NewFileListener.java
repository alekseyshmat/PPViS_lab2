package View.menuListeners;

import Controller.Controller;
import View.MainTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFileListener implements ActionListener {
    private Controller controller;
    private MainTable mainTable;

    public NewFileListener(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.clearData();
        mainTable = controller.getMainTable();
        controller.viewTeachers(mainTable, controller.getListOfTeachers());
        controller.created();
    }
}
