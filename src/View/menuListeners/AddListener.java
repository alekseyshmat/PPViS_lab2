package View.menuListeners;

import View.*;
import Controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddListener implements ActionListener {
    private AddFrame addFrame;
    private Controller controller;

    public AddListener(Controller controller) {
        addFrame = new AddFrame(controller);
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!MainTable.create) {
            JOptionPane.showMessageDialog(new JFrame(), "Создайте новую таблицу либо откройте уже существующую");
        } else {

            addFrame.frame.setVisible(true);
        }
    }
}
