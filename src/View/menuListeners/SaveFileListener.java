package View.menuListeners;

import Controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveFileListener implements ActionListener {
    private JFileChooser fileChooser;
    private Controller controller;

    public SaveFileListener(Controller controller) {
        this.controller = controller;
        fileChooser = new JFileChooser();
        Files files = new Files();
        fileChooser.setFileFilter(files);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            XMLDomParser parser = new XMLDomParser(controller.getListOfTeachers(), fileChooser.getSelectedFile().getPath());
            parser.parseInto();
        }
    }
}
