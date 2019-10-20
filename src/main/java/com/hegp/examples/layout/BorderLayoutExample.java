package com.hegp.examples.layout;

import com.hegp.examples.GlobalConfig;

import java.awt.*;

import javax.swing.*;

import static java.awt.BorderLayout.*;

public class BorderLayoutExample extends JFrame {

    private MenuBar frameMenuBar = null;// 菜单栏
    private ToolBar toolBar = null;     // 工具栏
    private DesktopPanel desktopPane = null;// 桌面面板
    private JLabel stateLabel = null;   // 选定窗体状态标签

    public JButton btn1=new JButton("东");
    public JButton btn2=new JButton("南");
    public JButton btn3=new JButton("西");
    public JButton btn4=new JButton("北");
    public JButton btn5=new JButton("中");

    public BorderLayoutExample(){
        initFrame();
    }

    public void initFrame() {
        this.setSize(800, 600);// 设置主窗体的宽高
        this.setJMenuBar(getFrameMenuBar());// 设置菜单栏
        this.setTitle("铭泰企业进销存管理系统");// 设置窗体的题目
        this.setLayout(new BorderLayout());// 设置内容面板的布局
        this.add(btn1,BorderLayout.EAST);
//        this.add(getStatePanel(), SOUTH);// 状态面板置于内容面板的南部
//        this.add(btn2,BorderLayout.SOUTH);
        this.add(btn3, BorderLayout.WEST);
        this.add(getJToolBar(), NORTH);// 工具栏置于内容面板的北部
        this.add(getDesktopPane(), CENTER);// 背景面板置于内容面板的中部
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(true);
    }

    /**
     * 初始化工具栏
     */
    private ToolBar getJToolBar() {
        if (toolBar == null) {// 工具栏对象为空
            toolBar = new ToolBar(getFrameMenuBar());// 创建工具栏对象
            toolBar.setCursor(new Cursor(Cursor.HAND_CURSOR));// 设置光标图像
        }
        return toolBar;
    }

    /**
     * 初始化窗体菜单栏的方法
     */
    protected MenuBar getFrameMenuBar() {
        if (frameMenuBar == null) {// 菜单栏对象为空
            frameMenuBar = new MenuBar(getDesktopPane(), getStateLabel());// 创建菜单栏对象
        }
        return frameMenuBar;
    }

    public JLabel getStateLabel() {// 获得选定窗体状态标签的方法
        if (stateLabel == null) {// 选定窗体状态标签对象为空
            stateLabel = new JLabel();// 创建选定窗体状态标签
            stateLabel.setText("当前没有选定窗体");// 设置选定窗体状态标签的文本内容
        }
        return stateLabel;
    }

    /**
     * 初始化桌面面板的方法
     */
    private DesktopPanel getDesktopPane() {
        if (desktopPane == null) {// 桌面面板对象为空
            desktopPane = new DesktopPanel();// 创建桌面面板对象
        }
        return desktopPane;
    }

    public static void main(String args[]) {
        GlobalConfig.setCurrentSystemStyle();
        new BorderLayoutExample();
    }
}