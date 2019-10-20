package com.hegp.examples.event;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JTreeClickAdapter extends MouseAdapter {
    private JTree tree;

    public JTreeClickAdapter(JTree tree) {
        this.tree = tree;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tree && e.getClickCount() == 2) {
            Rectangle rectangle = null;
            TreePath path = null;
            int x = tree.getX();
            int width = tree.getWidth();
            for (int i=x; i<x+width; i=i+5) {
                if (path==null) {
                    path = tree.getPathForLocation(i, e.getY());
                }
                if (path!=null) {
                    if (rectangle==null) {
                        rectangle = tree.getPathBounds(path);
                        // 点中item范围时, 放弃自定义双击事件, 跳出循环, 执行控件原有的点击事件
                        if (e.getX()>=rectangle.getX() && e.getX()<=(rectangle.getX() + rectangle.getWidth())) {
                            break;
                        }
                    }
                    if (rectangle!=null && (i < rectangle.getX() || i > (rectangle.getX() + rectangle.getWidth()))) {
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
                        if (node != null) {
                            if (tree.isExpanded(path)) {
                                tree.collapsePath(path);
                            } else {
                                tree.expandPath(path);
                            }
                            tree.setSelectionPath(path);
                            break;
                        }
                    }
                }
            }
        }

    }
}
