package com.hegp.examples.exam002;

import com.hegp.examples.GlobalConfig;

import java.awt.event.*;
import javax.swing.*;

public class Tab extends JFrame {
    public JMenuItem menu;
    public static JTabbedPane pane;

    public Tab() {
        super("选项卡窗格");
        setVisible(true);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu = new JMenuItem("增加");
        JMenu menu = new JMenu("增加");
        menu.add(this.menu);
        JMenuBar bar = new JMenuBar();
        bar.add(menu);
        setJMenuBar(bar);
        pane = new JTabbedPane();
        add(pane);
        new AddTab();
        this.menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (e.getSource() == menu) {
                    new AddTab();
//                }
            }
        });
    }

    public static void main(String[] args) throws Exception {
        GlobalConfig.setNimbusLookAndFeelStyl1e();
        new Tab();
    }


}
