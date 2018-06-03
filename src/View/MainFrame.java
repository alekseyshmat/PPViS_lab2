package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import Controller.*;
import Model.*;
import View.menuListeners.*;


public class MainFrame {
    public JFrame frame;
    private Controller controller;

    public MainFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(950, 450));
        frame.setLocation(300, 150);
        frame.setTitle("Таблица преподавателей");
        frame.setResizable(false);
        frame.setVisible(true);

        MainTable mainTable = new MainTable();
        DBTeacher dbTeacher = new DBTeacher();
        controller = new Controller(dbTeacher, mainTable, this);

        JMenuBar menuBa = addJMenuBar();
        frame.setJMenuBar(menuBa);

        JToolBar tool = addToolBar();
        frame.add(tool, BorderLayout.NORTH);
    }

    private JToolBar addToolBar() {
        JToolBar toolBar = new JToolBar(JToolBar.HORIZONTAL);
        setToolBar(toolBar);
        return toolBar;
    }

    private JButton createButton(JButton button, String imgName, String tips, String command) {
        button.setBorderPainted(false);
        String path = "img/" + imgName;
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
        button.setIcon(imageIcon);
        button.setToolTipText(tips);
        button.setActionCommand(command);
        return button;
    }

    private void setToolBar(JToolBar toolBar) {
        JButton openButton = createButton(new JButton(), "open.png", "Открыть", "Открыть");
        OpenFileListener openFileListener = new OpenFileListener(controller);
        openButton.addActionListener(openFileListener);

        JButton newButton = createButton(new JButton(), "new.png", "Создать", "Создать");
        NewFileListener newFileListener = new NewFileListener(controller);
        newButton.addActionListener(newFileListener);

        JButton addButton = createButton(new JButton(), "add.png", "Добавить", "Добавить");
        AddListener addListener = new AddListener(controller);
        addButton.addActionListener(addListener);

        JButton deleteButton = createButton(new JButton(), "delete.png", "Удалить", "Удалить");
        DeleteListener deleteListener = new DeleteListener(controller);
        deleteButton.addActionListener(deleteListener);

        JButton searchButton = createButton(new JButton(), "search.png", "Найти", "Найти");
        SearchListener searchListener = new SearchListener(controller);
        searchButton.addActionListener(searchListener);

        JButton saveButton = createButton(new JButton(), "save.png", "Cохранить", "Сохранить");
        SaveFileListener saveFileListener = new SaveFileListener(controller);
        saveButton.addActionListener(saveFileListener);

        toolBar.add(openButton);
        toolBar.add(newButton);
        toolBar.add(addButton);
        toolBar.add(searchButton);
        toolBar.add(deleteButton);
        toolBar.add(saveButton);

        toolBar.setFloatable(false);
        toolBar.setVisible(true);
    }

    private JMenuBar addJMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        return menuBar;
    }

    private void setJMenuBar(JMenuBar menuBar) {
        JMenu fileMenu = new JMenu("Файл");
        JMenu changeMenu = new JMenu("Изменить");
        JMenu exitMenu = new JMenu("Выход");

        JMenuItem newItem = new JMenuItem("Новый файл");
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
        NewFileListener newFileListener = new NewFileListener(controller);
        newItem.addActionListener(newFileListener);
        fileMenu.add(newItem);

        JMenuItem openItem = new JMenuItem("Открыть");
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        OpenFileListener openFileListener = new OpenFileListener(controller);
        openItem.addActionListener(openFileListener);
        fileMenu.add(openItem);

        JMenuItem saveItem = new JMenuItem("Сохранить");
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        SaveFileListener saveFileListener = new SaveFileListener(controller);
        saveItem.addActionListener(saveFileListener);
        fileMenu.add(saveItem);

        JMenuItem addItem = new JMenuItem("Добавить");
        addItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
        AddListener addListener = new AddListener(controller);
        addItem.addActionListener(addListener);
        changeMenu.add(addItem);

        JMenuItem searchItem = new JMenuItem("Найти");
        searchItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
        SearchListener searchListener = new SearchListener(controller);
        searchItem.addActionListener(searchListener);
        changeMenu.add(searchItem);

        JMenuItem deleteItem = new JMenuItem("Удалить");
        deleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        DeleteListener deleteListener = new DeleteListener(controller);
        deleteItem.addActionListener(deleteListener);
        changeMenu.add(deleteItem);

        JMenuItem exitItem = new JMenuItem("Выход");
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exitMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(changeMenu);
        menuBar.add(exitMenu);
    }
}
