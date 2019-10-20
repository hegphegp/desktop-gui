package com.hegp.examples.layout;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.net.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

public class MenuBar extends JMenuBar {// 菜单栏

	/** （进货管理）菜单 */
	private JMenu jinhuo_Menu = null;
	/** （进货单）菜单项，位于（进货管理）菜单内 */
	private JMenuItem jinhuoItem = null;
	/** （进货退货）菜单项，位于（进货管理）菜单内 */
	private JMenuItem jinhuo_tuihuoItem = null;
	/** （信息查询）菜单 */
	private JMenu xinxi_chaxunMenu = null;
	/** （帮助）菜单 */
	private JMenu bang_zhuMenu = null;
	/** （关于）菜单项，位于（帮助）菜单内 */
	private JMenuItem guanyu_Item = null;
	/** （联系技术支持）菜单项，位于（帮助）菜单内 */
	private JMenuItem bugItem = null;
	/** （访问技术网站）菜单项，位于（帮助）菜单内 */
	private JMenuItem fangwen_wangzhanItem = null;
	/** （销售单）菜单项，位于（销售管理）菜单内 */
	private JMenuItem xiaoshou_danItem = null;
	/** （销售查询）菜单项，位于（信息查询）菜单内 */
	private JMenuItem xiaoshou_chaxunItem = null;
	/** （商品查询）菜单项，位于（信息查询）菜单内 */
	private JMenuItem shangpin_chaxunItem = null;
	/** （销售排行）菜单项，位于（信息查询）菜单内 */
	private JMenuItem xiaoshou_paihangItem = null;
	/** （退出）菜单项，位于（系统维护）菜单内 */
	private JMenuItem exitItem = null;
	/** 容纳内部窗体的桌面面板 */
	private JDesktopPane desktopPanel = null;
	/** 内部窗体的集合 */
	private Map<JMenuItem, JInternalFrame> iFrames = null;
	/** 内部窗体的位置坐标 */
	private int nextFrameX, nextFrameY;
	/** 状态栏的内部窗体提示标签 */
	private JLabel stateLabel = null;

	private MenuBar() { }

	public MenuBar(JDesktopPane desktopPanel, JLabel label) {
		super();
		iFrames = new HashMap();
		this.desktopPanel = desktopPanel;
		this.stateLabel = label;
		initialize();
	}

	/**
	 * 初始化菜单栏界面的方法
	 */
	private void initialize() {
		this.setSize(new Dimension(600, 24));
		add(getJinhuo_Menu());
		add(getXinxi_chaxunMenu());
		add(getBang_zhuMenu());
	}

	/**
	 * 初始化进货管理菜单的方法
	 */
	public JMenu getJinhuo_Menu() {
		if (jinhuo_Menu == null) {
			jinhuo_Menu = new JMenu();
			jinhuo_Menu.setText("进货管理(J)");
			jinhuo_Menu.setMnemonic(KeyEvent.VK_J);
			jinhuo_Menu.add(getJinhuoItem());
			jinhuo_Menu.add(getJinhuo_tuihuoItem());
		}
		return jinhuo_Menu;
	}

	/**
	 * 初始化（进货单）菜单项的方法 该方法定义菜单项打开进货单窗口,并使窗口处于被选择状态
	 */
	public JMenuItem getJinhuoItem() {
		if (jinhuoItem == null) {
			jinhuoItem = new JMenuItem();
			jinhuoItem.setText("进货单");
			jinhuoItem.setIcon(new ImageIcon(this.getClass().getResource("/res/icon/jinhuodan.png")));
			jinhuoItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createIFrame(jinhuoItem, JinHuoDanIFrame.class);
				}
			});
		}
		return jinhuoItem;
	}

	/**
	 * 初始化（进货退货）菜单项的方法，该方法定义菜单项打开（进货退货）窗体，并使窗体处于已选择状态。
	 */
	public JMenuItem getJinhuo_tuihuoItem() {
		if (jinhuo_tuihuoItem == null) {
			jinhuo_tuihuoItem = new JMenuItem();
			jinhuo_tuihuoItem.setText("进货退货");
			jinhuo_tuihuoItem.setIcon(new ImageIcon(this.getClass().getResource("/res/icon/jinhuodan.png")));
			jinhuo_tuihuoItem.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(jinhuo_tuihuoItem, JinHuoDanIFrame.class);
				}
			});
		}
		return jinhuo_tuihuoItem;
	}

	/**
	 * 初始化（信息查询）菜单的方法
	 */
	public JMenu getXinxi_chaxunMenu() {
		if (xinxi_chaxunMenu == null) {
			xinxi_chaxunMenu = new JMenu();
			xinxi_chaxunMenu.setText("信息查询(C)");
			xinxi_chaxunMenu.setMnemonic(KeyEvent.VK_C);
			xinxi_chaxunMenu.add(getXiaoshou_chaxunItem());
			xinxi_chaxunMenu.add(getShangpin_chaxunItem());
			xinxi_chaxunMenu.addSeparator();
			xinxi_chaxunMenu.add(getXiaoshou_paihangItem());
		}
		return xinxi_chaxunMenu;
	}

	/**
	 * 初始化（帮助）菜单的方法
	 */
	public JMenu getBang_zhuMenu() {
		if (bang_zhuMenu == null) {
			bang_zhuMenu = new JMenu();
			bang_zhuMenu.setText("帮助(H)");
			bang_zhuMenu.setMnemonic(KeyEvent.VK_H);
			bang_zhuMenu.add(getGuanyu_Item());
			bang_zhuMenu.add(getBugItem());
			bang_zhuMenu.add(getFangwen_wangzhanItem());
		}
		return bang_zhuMenu;
	}

	/**
	 * 初始化（关于）菜单项的方法
	 */
	private JMenuItem getGuanyu_Item() {
		if (guanyu_Item == null) {
			guanyu_Item = new JMenuItem();
			guanyu_Item.setText("关于");
			guanyu_Item.setIcon(new ImageIcon(this.getClass().getResource("/res/icon/jinhuodan.png")));
			ImageIcon aboutImage = new ImageIcon(this.getClass().getResource("/res/icon/jinhuodan.png"));
			final JLabel imgLabel = new JLabel(aboutImage);
			imgLabel.setVisible(false);
			desktopPanel.add(imgLabel);
			desktopPanel.setLayer(imgLabel, Integer.MAX_VALUE);
			guanyu_Item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int dw = desktopPanel.getWidth();
					int dh = desktopPanel.getHeight();
					imgLabel.setBounds((dw - 500) / 2, (dh - 350) / 2, 500, 350);
					imgLabel.setVisible(true);
				}
			});
			imgLabel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					imgLabel.setVisible(false);
				}
			});
		}
		return guanyu_Item;
	}

	/**
	 * 初始化（联系技术支持）菜单项的方法
	 */
	public JMenuItem getBugItem() {
		if (bugItem == null) {
			bugItem = new JMenuItem();
			bugItem.setText("联系技术支持");
			bugItem.setIcon(new ImageIcon(this.getClass().getResource("/res/icon/jinhuodan.png")));
			bugItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						try {
							URI uri = new URI("mailto:tmoonbook@sina.com");
							desktop.mail(uri);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return bugItem;
	}

	/**
	 * 初始化（访问技术网站）菜单项的方法
	 */
	public JMenuItem getFangwen_wangzhanItem() {
		if (fangwen_wangzhanItem == null) {
			fangwen_wangzhanItem = new JMenuItem();
			fangwen_wangzhanItem.setText("访问技术网站");
			fangwen_wangzhanItem.setIcon(new ImageIcon(this.getClass().getResource("/res/icon/jinhuodan.png")));
			fangwen_wangzhanItem.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						try {
							URL url = new URL("http://www.mrbccd.com");
							desktop.browse(url.toURI());
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return fangwen_wangzhanItem;
	}

	/**
	 * 初始化（销售单）菜单项的方法
	 */
	public JMenuItem getXiaoshou_danItem() {
		if (xiaoshou_danItem == null) {
			xiaoshou_danItem = new JMenuItem();
			xiaoshou_danItem.setText("销售单");
			xiaoshou_danItem.setIcon(new ImageIcon(this.getClass().getResource("/res/icon/jinhuodan.png")));
			xiaoshou_danItem.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(xiaoshou_danItem, JinHuoDanIFrame.class);
				}
			});
		}
		return xiaoshou_danItem;
	}

	/**
	 * 初始化（销售查询）菜单项的方法
	 */
	public JMenuItem getXiaoshou_chaxunItem() {
		if (xiaoshou_chaxunItem == null) {
			xiaoshou_chaxunItem = new JMenuItem();
			xiaoshou_chaxunItem.setText("销售查询");
			xiaoshou_chaxunItem.setIcon(new ImageIcon(this.getClass().getResource("/res/icon/jinhuodan.png")));
			xiaoshou_chaxunItem.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(xiaoshou_chaxunItem, JinHuoDanIFrame.class);
				}
			});
		}
		return xiaoshou_chaxunItem;
	}

	/**
	 * 初始化（商品查询）菜单项的方法
	 */
	public JMenuItem getShangpin_chaxunItem() {
		if (shangpin_chaxunItem == null) {
			shangpin_chaxunItem = new JMenuItem();
			shangpin_chaxunItem.setText("商品查询");
			shangpin_chaxunItem.setIcon(new ImageIcon(this.getClass().getResource("/res/icon/jinhuodan.png")));
			shangpin_chaxunItem.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(shangpin_chaxunItem, JinHuoDanIFrame.class);
				}
			});
		}
		return shangpin_chaxunItem;
	}

	/**
	 * 初始化（销售排行）菜单项的方法
	 */
	public JMenuItem getXiaoshou_paihangItem() {
		if (xiaoshou_paihangItem == null) {
			xiaoshou_paihangItem = new JMenuItem();
			xiaoshou_paihangItem.setText("销售排行");
			xiaoshou_paihangItem.setIcon(new ImageIcon(this.getClass().getResource("/res/icon/jinhuodan.png")));
			xiaoshou_paihangItem.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(xiaoshou_paihangItem, JinHuoDanIFrame.class);
				}
			});
		}
		return xiaoshou_paihangItem;
	}

	/**
	 * 初始化（退出系统）菜单项的方法
	 */
	public JMenuItem getExitItem() {
		if (exitItem == null) {
			exitItem = new JMenuItem();
			exitItem.setText("退出系统");
			exitItem.setIcon(new ImageIcon(this.getClass().getResource("/res/icon/jinhuodan.png")));
			exitItem.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitItem;
	}

	/**
	 * 创建内部窗体的方法，该方法使用反射技术获取内部窗体的构造方法，从而创建内部窗体。
	 * @param item：激活该内部窗体的菜单项
	 * @param clazz：内部窗体的Class对象
	 */
	private JInternalFrame createIFrame(JMenuItem item, Class clazz) {
		Constructor constructor = clazz.getConstructors()[0];
		JInternalFrame iFrame = iFrames.get(item);
		try {
			if (iFrame == null || iFrame.isClosed()) {
				iFrame = (JInternalFrame) constructor.newInstance(new Object[] {});
				iFrames.put(item, iFrame);
				iFrame.setFrameIcon(item.getIcon());
				iFrame.setLocation(nextFrameX, nextFrameY);
				int frameH = iFrame.getPreferredSize().height;
				int panelH = iFrame.getContentPane().getPreferredSize().height;
				int fSpacing = frameH - panelH;
				nextFrameX += fSpacing;
				nextFrameY += fSpacing;
				if (nextFrameX + iFrame.getWidth() > desktopPanel.getWidth())
					nextFrameX = 0;
				if (nextFrameY + iFrame.getHeight() > desktopPanel.getHeight())
					nextFrameY = 0;
				desktopPanel.add(iFrame);
				iFrame.setResizable(false);
				iFrame.setMaximizable(false);
				iFrame.setVisible(true);
			}
			iFrame.setSelected(true);
			stateLabel.setText(iFrame.getTitle());
			iFrame.addInternalFrameListener(new InternalFrameAdapter() {
				public void internalFrameActivated(InternalFrameEvent e) {
					super.internalFrameActivated(e);
					JInternalFrame frame = e.getInternalFrame();
					stateLabel.setText(frame.getTitle());
				}

				public void internalFrameDeactivated(InternalFrameEvent e) {
					stateLabel.setText("没有选择窗体");
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iFrame;
	}
}
