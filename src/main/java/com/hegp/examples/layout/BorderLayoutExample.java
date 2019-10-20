package com.hegp.examples.layout;

import com.hegp.examples.GlobalConfig;

import java.awt.*;
import java.util.Date;

import javax.swing.*;

import static java.awt.BorderLayout.*;
import static javax.swing.border.BevelBorder.RAISED;

public class BorderLayoutExample extends JFrame {

    private MenuBar frameMenuBar = null;// 菜单栏
    private ToolBar toolBar = null;     // 工具栏
    private DesktopPanel desktopPane = null;// 桌面面板
    private JPanel statePanel = null;   // 状态面板（内含选定窗体状态、操作员、当前日期、公司名称等信息）
    private JLabel stateLabel = null;   // 选定窗体状态标签
    private JLabel nameLabel = null;    // “公司名称”标签
    private JLabel nowDateLabel = null; // “当前日期”标签
    private JSeparator jSeparator1 = null;// 分隔符
    private JLabel czyStateLabel = null;// “操作员”标签
    private JSeparator jSeparator2 = null;// 分隔符

    //
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
        this.add(getStatePanel(), SOUTH);// 状态面板置于内容面板的南部
        this.add(btn3,BorderLayout.WEST);
        this.add(getJJToolBar(), NORTH);// 工具栏置于内容面板的北部
        this.add(getDesktopPane(), CENTER);// 背景面板置于内容面板的中部
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(true);
    }

    /**
     * 初始化工具栏
     */
    private ToolBar getJJToolBar() {
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

    /**
     * 初始化状态面板的方法
     *
     * @return JPanel
     */
    private JPanel getStatePanel() {
        if (statePanel == null) {// 状态面板对象为空
            GridBagConstraints gridBagConstraints6 = new GridBagConstraints();// 创建网格限制对象
            gridBagConstraints6.gridx = 2;// 组件位于网格的横向索引为2
            gridBagConstraints6.fill = GridBagConstraints.VERTICAL;// 组件垂直扩大以占据空白区域
            gridBagConstraints6.insets = new Insets(0, 5, 0, 5);// 组件彼此的间距
            gridBagConstraints6.gridy = 0;// 组件位于网格的纵向索引为0
            GridBagConstraints gridBagConstraints4 = new GridBagConstraints();// 创建网格限制对象
            gridBagConstraints4.gridx = 3;// 组件位于网格的横向索引为3
            gridBagConstraints4.gridy = 0;// 组件位于网格的纵向索引为0
            GridBagConstraints gridBagConstraints3 = new GridBagConstraints();// 创建网格限制对象
            gridBagConstraints3.gridx = 6;// 组件位于网格的横向索引为6
            gridBagConstraints3.fill = GridBagConstraints.VERTICAL;// 组件垂直扩大以占据空白区域
            gridBagConstraints3.insets = new Insets(0, 5, 0, 5);// 组件彼此的间距
            gridBagConstraints3.gridy = 0;// 组件位于网格的纵向索引为0
            GridBagConstraints gridBagConstraints11 = new GridBagConstraints();// 创建网格限制对象
            gridBagConstraints11.gridx = 5;// 组件位于网格的横向索引为5
            gridBagConstraints11.insets = new Insets(0, 5, 0, 5);// 组件彼此的间距
            gridBagConstraints11.gridy = 0;// 组件位于网格的纵向索引为0
            nowDateLabel = new JLabel();// “当前日期”标签
            Date now = new Date();// 创建Date对象
            nowDateLabel.setText(String.format("%tF", now));// 设置“当前日期”标签的文本内容
            GridBagConstraints gridBagConstraints2 = new GridBagConstraints();// 创建网格限制对象
            gridBagConstraints2.gridx = 7;// 组件位于网格的横向索引为7
            gridBagConstraints2.weightx = 0.0;// 组件横向上不扩大
            gridBagConstraints2.fill = GridBagConstraints.NONE;// 组件不扩大
            gridBagConstraints2.gridy = 0;// 组件位于网格的纵向索引为0
            nameLabel = new JLabel("吉林省铭泰××有限公司   ");// “公司名称”标签
            GridBagConstraints gridBagConstraints1 = new GridBagConstraints();// 创建网格限制对象
            gridBagConstraints1.gridx = 4;// 组件位于网格的横向索引为4
            gridBagConstraints1.fill = GridBagConstraints.VERTICAL;// 组件垂直扩大以占据空白区域
            gridBagConstraints1.weighty = 1.0;// 组件纵向扩大的权重是1.0
            gridBagConstraints1.insets = new Insets(0, 5, 0, 5);// 组件彼此的间距
            gridBagConstraints1.gridy = 0;// 组件位于网格的纵向索引为0
            GridBagConstraints gridBagConstraints = new GridBagConstraints();// 创建网格限制对象
            gridBagConstraints.gridx = 0;// 组件位于网格的横向索引为0
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
            gridBagConstraints.weightx = 1.0;// 组件横向扩大的权重是1.0
            gridBagConstraints.gridy = 0;// 组件位于网格的纵向索引为0
            statePanel = new JPanel();// 状态面板
            statePanel.setLayout(new GridBagLayout());// 设置状态面板的布局
            statePanel.setBorder(BorderFactory.createBevelBorder(RAISED));// 设置状态面板的边框
            statePanel.add(getStateLabel(), gridBagConstraints);// 向状态面板中添加选定窗体状态标签
            statePanel.add(getJSeparator(), gridBagConstraints1);// 向状态面板中添加分隔符
            statePanel.add(nameLabel, gridBagConstraints2);// 向状态面板中添加“公司名称”标签
            statePanel.add(getJSeparator1(), gridBagConstraints3);// 向状态面板中添加分隔符
            statePanel.add(nowDateLabel, gridBagConstraints11);// 向状态面板中添加“当前日期”标签
            statePanel.add(getCzyStateLabel(), gridBagConstraints4);// 向状态面板中添加“操作员”标签
            statePanel.add(getJSeparator2(), gridBagConstraints6);// 向状态面板中添加分隔符
        }
        return statePanel;
    }

    private JSeparator getJSeparator() {// 获得分隔符
        JSeparator jSeparator = new JSeparator();// 创建分隔符对象
        jSeparator.setOrientation(JSeparator.VERTICAL);// 竖直分隔符
        return jSeparator;
    }

    public JLabel getCzyStateLabel() {// 获得“操作员”标签的方法
        if (czyStateLabel == null) {// “操作员”标签对象为空
            czyStateLabel = new JLabel("操作员：");// 创建“操作员”标签
        }
        return czyStateLabel;
    }

    private JSeparator getJSeparator2() {// 获得分隔符
        if (jSeparator2 == null) {// 分隔符对象为空
            jSeparator2 = new JSeparator();// 创建分隔符对象
            jSeparator2.setOrientation(SwingConstants.VERTICAL);// 竖直分隔符
        }
        return jSeparator2;
    }

    private JSeparator getJSeparator1() {// 获得分隔符
        if (jSeparator1 == null) {// 分隔符对象为空
            jSeparator1 = new JSeparator();// 创建分隔符对象
            jSeparator1.setOrientation(SwingConstants.VERTICAL);// 竖直分隔符
        }
        return jSeparator1;
    }

    public static void main(String args[]) {
        GlobalConfig.setNimbusLookAndFeelStyl1e();
        GlobalConfig.setUIFont();
        new BorderLayoutExample();
    }
}