package com.hegp.examples.exam001;

import com.hegp.examples.GlobalConfig;
import com.hegp.examples.components.CloseTabbedItem;
import com.hegp.examples.components.CloseTabbedPane;
import com.hegp.examples.event.JTreeClickAdapter;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.plaf.FontUIResource;
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
    public JPanel mainPanel = new JPanel();
    public CloseTabbedPane closeTabbedPane;
    private Icon icon = new ImageIcon(this.getClass().getResource("/res/icon/jinhuodan.png"));

    public static void main(String args[]) {
        GlobalConfig.setNimbusLookAndFeelStyl1e();
        LayoutMenu frame = new LayoutMenu();
        frame.setVisible(true);
    }
    
    public LayoutMenu() {
        super();
        this.setSize(800, 600);// 设置主窗体的宽高
        this.setJMenuBar(initMenuBar());// 设置菜单栏
        this.setTitle("铭泰企业进销存管理系统");// 设置窗体的题目

        this.getContentPane().add(mainPanel);
        mainPanel.setLayout(new BorderLayout());// 设置内容面板的布局
//        this.add(getStatePanel(), SOUTH);// 状态面板置于内容面板的南部
//        this.add(btn2,BorderLayout.SOUTH);
//        this.add(btn3, BorderLayout.WEST);
        mainPanel.add(initToolBar(), NORTH);// 工具栏置于内容面板的北部
        mainPanel.add(initSplitPane(), CENTER);// 背景面板置于内容面板的中部
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);

    }

    private JTabbedPane initCloseTabbedPane() {
        closeTabbedPane = new CloseTabbedPane();
        for (int i = 0; i < 3; i++) {
            closeTabbedPane.addTabbedItem(new JPanel(), "面板"+ closeTabbedPane.getTabCount());
        }

        // 设置默认选中的选项卡
        closeTabbedPane.setSelectedIndex(1);
        return closeTabbedPane;
    }

    private JSplitPane initSplitPane() {
        JSplitPane splitPane=new JSplitPane();//创建一个分割容器类
//        splitPane.setOneTouchExpandable(true);//让分割线显示出箭头
        splitPane.setContinuousLayout(true);//操作箭头，重绘图形
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);//设置分割线方向 纵向分布
        splitPane.setLeftComponent(initJTree());//设置左边的组件
        splitPane.setRightComponent(initCloseTabbedPane());//设置右边的组件
        splitPane.setDividerSize(5);//设置分割线的大小
        splitPane.setDividerLocation(200);//设置分割线位于中央
        return splitPane;
    }

    private JToolBar initToolBar(){
        JToolBar toolBar = new JToolBar();
        for (int i = 1; i < 10; i++) {
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
        @Override
        public void actionPerformed(ActionEvent e) {
            closeTabbedPane.addTabbedItem(new CloseTabbedItem(new JPanel(), "面板"+ closeTabbedPane.getTabCount()));
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
        tree.addMouseListener(new JTreeClickAdapter(tree));

        // 添加选择事件
        tree.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node!=null && node.isLeaf()) {
                    System.out.println("你选择了：" + node.getUserObject().toString());
                }

            }
        });
        return tree;
    }

    /**
     * 创建一个面板，面板中心显示一个标签，用于表示某个选项卡需要显示的内容
     */
    private static JComponent createTextPanel(String text) {
        // 创建面板, 使用一个 1 行 1 列的网格布局（为了让标签的宽高自动撑满面板）
        JPanel panel = new JPanel(new GridLayout(1, 1));

        // 创建标签
        JLabel label = new JLabel(text);
        label.setFont(new Font(null, Font.PLAIN, 50));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // 添加标签到面板
        panel.add(label);

        return panel;
    }
}
