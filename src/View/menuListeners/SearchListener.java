package View.menuListeners;

import Controller.*;
import View.MainTable;
import View.SearchFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchListener implements ActionListener {
    private SearchFrame searchFrame;
    private Controller controller;

    public SearchListener(Controller controller) {
        searchFrame = new SearchFrame(controller);
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!MainTable.create) {
            JOptionPane.showMessageDialog(new JFrame(), "Создайте новую таблицу либо откройте уже существующую");
        } else {
            searchFrame.frame.setVisible(true);
        }

    }
}
