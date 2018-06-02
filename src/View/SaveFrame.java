package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveFrame {
    private JFrame frame = new JFrame();

    public SaveFrame() {
        frame.setTitle("Сохранение");
        frame.setSize(new Dimension(100, 50));
        frame.setResizable(false);
        frame.setLocation(200, 200);

        JLabel textSave = new JLabel("Вы хотите сохранить изменения?");
        textSave.add(frame);
        JButton saveButton = new JButton("Сохранить");
        JButton notSaveButton = new JButton("Не сохранять");
        JButton cancelButton = new JButton("Отмена");

        ActionListener addButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        saveButton.addActionListener(addButtonListener);
        ActionListener cancelButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        };
        cancelButton.addActionListener(cancelButtonListener);
        ActionListener notsaveButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        notSaveButton.addActionListener(notsaveButtonListener);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        frame.add(panel);
    }
}
