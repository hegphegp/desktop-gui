package com.hegp.examples.exam002;

import com.hegp.examples.GlobalConfig;
import com.hegp.examples.components.CloseTabbedItem;
import com.hegp.examples.components.CloseTabbedPane;

import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {
    public JMenuItem menu;
    public CloseTabbedPane closeTabbedPane;

    public Main() {
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
        closeTabbedPane = new CloseTabbedPane();
        setContentPane(closeTabbedPane);
        closeTabbedPane.addTabbedItem(new CloseTabbedItem(new JPanel(), "面板"+ closeTabbedPane.getTabCount()));
        this.menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (e.getSource() == menu) {
                closeTabbedPane.addTabbedItem(new CloseTabbedItem(new JPanel(), "面板"+ closeTabbedPane.getTabCount()));
//                }
            }
        });
    }

    public static void main(String[] args) throws Exception {
        GlobalConfig.setNimbusLookAndFeelStyl1e();
        new Main();
    }


}
