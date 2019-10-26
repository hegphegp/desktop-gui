package com.hegp.examples.exam002;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddTab implements MouseListener {
    public JPanel panel;
    public JLabel label;
    public JLabel lab3 = new JLabel();

    public AddTab() {
        label = new JLabel("选项卡选项卡选项卡选项卡选项卡");
        JLabel lab1 = new JLabel("选项卡选项卡选项卡选项卡选项卡");
        panel = new JPanel();
        GridLayout gl = new GridLayout(1, 1, 10, 0);
        panel.setLayout(gl);
        lab1.setHorizontalAlignment(JLabel.LEFT);//设置文字显示在最左边
        lab3.setHorizontalAlignment(JLabel.RIGHT);// 设置文字显示在最右边
        panel.add(lab1);
        panel.add(lab3);
        Tab.pane.addTab("", label);
        Tab.pane.setTabComponentAt(Tab.pane.indexOfComponent(label), panel);//实现这个功能的就这一条最重要的语句
        lab3.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        Tab.pane.remove(Tab.pane.indexOfTabComponent(panel));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        lab3.setText(" X ");
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        lab3.setText("");
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

}
