package com.hegp.examples.exam001;

import com.hegp.examples.GlobalConfig;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;

public class LayoutMenu extends JFrame {
    
    private static final long serialVersionUID = 1L;
    public JButton btn1=new JButton("东");
    public JButton btn2=new JButton("南");
    public JButton btn3=new JButton("西");
    public JButton btn4=new JButton("北");
    public JButton btn5=new JButton("中");
    private Icon icon = new ImageIcon(this.getClass().getResource("/res/icon/jinhuodan.png"));

    public static void main(String args[]) {
        GlobalConfig.setCurrentSystemStyle();
        LayoutMenu frame = new LayoutMenu();
        frame.setVisible(true);
    }
    
    public LayoutMenu() {
        super();
        this.setSize(800, 600);// 设置主窗体的宽高
        this.setJMenuBar(initMenuBar());// 设置菜单栏
        this.setTitle("铭泰企业进销存管理系统");// 设置窗体的题目
        this.setLayout(new BorderLayout());// 设置内容面板的布局
//        this.add(getStatePanel(), SOUTH);// 状态面板置于内容面板的南部
//        this.add(btn2,BorderLayout.SOUTH);
//        this.add(btn3, BorderLayout.WEST);
        this.add(initToolBar(), NORTH);// 工具栏置于内容面板的北部
        this.add(initSplitPane(), CENTER);// 背景面板置于内容面板的中部
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
    }

    private JSplitPane initSplitPane() {
        JPanel rightPanel= new JPanel();
        JSplitPane splitPane=new JSplitPane();//创建一个分割容器类
//        splitPane.setOneTouchExpandable(true);//让分割线显示出箭头
        splitPane.setContinuousLayout(true);//操作箭头，重绘图形
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);//设置分割线方向 纵向分布
        splitPane.setLeftComponent(initJTree());//设置左边的组件
        splitPane.setRightComponent(rightPanel);//设置右边的组件
        splitPane.setDividerSize(5);//设置分割线的大小
        splitPane.setDividerLocation(200);//设置分割线位于中央
        return splitPane;
    }

    private JToolBar initToolBar(){
        JToolBar toolBar = new JToolBar();
        for (int i = 1; i < 7; i++) {
            JButton button = new JButton("工具"+i);
            button.setIcon(icon);
            toolBar.add(button);
        }
        return toolBar;
    }

    private JMenuBar initMenuBar() {
        JMenuBar menuBar = new JMenuBar();// 创建菜单栏对象
        menuBar.add(initJMenu());// 将菜单对象添加到菜单栏对象中
        menuBar.add(initJMenu());// 将菜单对象添加到菜单栏对象中
        menuBar.add(initJMenu());// 将菜单对象添加到菜单栏对象中
        menuBar.add(initJMenu());// 将菜单对象添加到菜单栏对象中
        menuBar.add(initJMenu());// 将菜单对象添加到菜单栏对象中
        return menuBar;
    }

    private JMenu initJMenu() {
        JMenu menu = new JMenu("菜单名称");// 创建菜单对象
        menu.setIcon(icon);

        JMenuItem menuItem = new JMenuItem("菜单项名称");// 创建菜单项对象
        menuItem.setIcon(icon);
        menuItem.addActionListener(listener);// 为菜单项添加事件监听器
        menu.add(menuItem);// 将菜单项对象添加到菜单对象中

        JMenu sonMenu = new JMenu("子菜单名称");// 创建菜单的子菜单对象
        sonMenu.setIcon(icon);
        menu.add(sonMenu);// 将子菜单对象添加到上级菜单对象中

        JMenuItem sonMenuItem = new JMenuItem("子菜单项名称");// 创建子菜单的菜单项对象
        sonMenuItem.setIcon(icon);
        sonMenuItem.addActionListener(listener);// 为菜单项添加事件监听器
        sonMenu.add(sonMenuItem);// 将子菜单的菜单项对象添加到子菜单对象中
        return menu;
    }

    private ActionListener listener = new ItemListener();

    private class ItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JMenuItem menuItem = (JMenuItem) e.getSource();
            System.out.println("您单击的是菜单项：" + menuItem.getText());
        }
    }

    private JTree initJTree() {
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("职员管理");

        for (int i = 1; i < 4; i++) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode("软件部"+i);
            for (int j = 1; j < 10; j++) {
                node.add(new DefaultMutableTreeNode("小虎"+i+j));
            }
            top.add(node);
        }
        top.add(new DefaultMutableTreeNode("总经理"));
        JTree tree = new JTree(top);
        // 添加选择事件
        tree.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node == null)
                    return;

                if (node.isLeaf()) {
                    System.out.println("你选择了：" + node.getUserObject().toString());
                }

            }
        });
        return tree;
    }
}
