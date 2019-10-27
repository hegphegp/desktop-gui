package com.hegp.examples.components;

import com.hegp.examples.components.CloseTabIcon;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class CloseTabbedItem {
    public JTabbedPane tabbedPane;
    public JPanel tabHeaderPanel = new JPanel();
    public static Icon closeTabIcon = new CloseTabIcon();
    public JLabel closeTab = new JLabel(closeTabIcon);
    public String tabHeaderTitle;
    public JPanel contentPane;
    public JLabel tabHeaderLabel = new JLabel();

    public CloseTabbedItem(JPanel contentPane, String tabHeaderTitle) {
        this.tabHeaderTitle = " "+tabHeaderTitle+" ";
        this.tabHeaderLabel.setText(this.tabHeaderTitle);
        this.contentPane = contentPane;
    }

    public void init() {
        tabHeaderLabel.setText(this.tabHeaderTitle);
        tabHeaderPanel.setLayout(new BorderLayout());
        tabHeaderPanel.add(tabHeaderLabel, BorderLayout.WEST);
        tabHeaderPanel.add(closeTab, BorderLayout.EAST);
        closeTab.setPreferredSize(new Dimension(closeTabIcon.getIconWidth(), closeTabIcon.getIconHeight()));
        tabbedPane.addTab("", contentPane);
        tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tabHeaderPanel);//实现这个功能的就这一条最重要的语句
        closeTab.addMouseListener(new TabCloseAdapter());
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    public String getTabHeaderTitle() {
        return tabHeaderTitle;
    }

    public void setTabHeaderTitle(String tabHeaderTitle) {
        this.tabHeaderTitle = " "+tabHeaderTitle+" ";
        this.tabHeaderLabel.setText(this.tabHeaderTitle);
    }

    public class TabCloseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent arg0) {
            if (tabbedPane.getTabCount()<2) {
                JOptionPane.showMessageDialog(null, "还剩最后一个窗口， 不允许关闭", null, JOptionPane.PLAIN_MESSAGE);
            } else {
                tabbedPane.remove(tabbedPane.indexOfTabComponent(tabHeaderPanel));
            }
        }
    }

}
