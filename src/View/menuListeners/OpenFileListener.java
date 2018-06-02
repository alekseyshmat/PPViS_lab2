package View.menuListeners;

import Controller.Controller;
import Controller.Files;
import Model.*;
import View.MainTable;
import View.SaveFrame;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class OpenFileListener implements ActionListener {
    private JFileChooser fileChooser;
    private Controller controller;

    public OpenFileListener(Controller controller) {
        this.controller = controller;

        Files files = new Files();
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(files);
        fileChooser.setCurrentDirectory(new java.io.File("E:/JAVA/PPViS_2/src"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.clearData();
        MainTable mainTable = controller.getMainTable();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser parser = factory.newSAXParser();
                XMLSaxParser handler = new XMLSaxParser();

                File file = new File(fileChooser.getSelectedFile().getPath());
                parser.parse(file, handler);

                List<Teacher> listData = handler.getTeacherList();
                controller.DataBase(listData);
                controller.created();
                controller.viewTeachers(mainTable, controller.getListOfTeachers());


            } catch (SAXException | ParserConfigurationException | IOException eSAX) {
                eSAX.printStackTrace();
            }

        }
    }

}

