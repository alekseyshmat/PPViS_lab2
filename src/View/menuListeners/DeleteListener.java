package View.menuListeners;

import Controller.Controller;
import View.DeleteFrame;
import View.MainTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener {
    private DeleteFrame deleteFrame;
    private Controller controller;

    public DeleteListener(Controller controller) {
        deleteFrame =new DeleteFrame(controller);
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!MainTable.create) {
            JOptionPane.showMessageDialog(new JFrame(), "Создайте новую таблицу либо откройте уже существующую");
        } else {
            deleteFrame.frame.setVisible(true);
        }
    }
}
