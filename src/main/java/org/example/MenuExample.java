package org.example;
import javax.swing.*;
import java.awt.event.*;

public class MenuExample  extends JFrame{
    public MenuExample(){
        setTitle("Menu");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createMenuBar();
        createPopupMenuOnPanel();
    }
    private void createMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu file = createFileMenu();
        file.setMnemonic('F');//alt+F
        menuBar.add(file);
        JMenu edit = createEditMenu();
        menuBar.add(edit);
        setJMenuBar(menuBar);
    }
    private void createPopupMenuOnPanel(){
        JPanel panel = new JPanel();
        JPopupMenu popupMenu = createPopupMenu();
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.isPopupTrigger()){
                    popupMenu.show(e.getComponent(),e.getX(),e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        add(panel);
    }
    private JPopupMenu createPopupMenu(){
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem copy = new JMenuItem("copy");
        JMenuItem paste = new JMenuItem("paste");
        popupMenu.add(copy);
        popupMenu.add(paste);
        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MenuExample.this,"You copy smth");
            }
        });
        return popupMenu;
    }
    private JMenu createFileMenu(){
        JMenu file = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New",new ImageIcon(""));
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK|InputEvent.ALT_DOWN_MASK));
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_DOWN_MASK));
        file.add(newItem);
        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(exit);
        return file;
    }
    private JMenu createEditMenu(){
        JMenu edit = new JMenu("Edit");
        return edit;
    }
    public static void main(String[] args) {
        MenuExample example = new MenuExample();
        example.setVisible(true);
    }
}