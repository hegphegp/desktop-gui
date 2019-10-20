package com.hegp.examples;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class GlobalConfig {
    //设置系统样式
    public static void setCurrentSystemStyle() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 在Ubuntu-18.04下, 设置样式com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel 与全局字体有冲突, 不知道其他版本或者Windows是否存在这种情况
     */
    public static void setNimbusLookAndFeelStyl1e() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setUIFont() {
        FontUIResource font = new FontUIResource("微软雅黑", Font.BOLD, 15);

        Set<String> hasConfig = new HashSet();
        /** 统一所有子窗口设置字体样式 */
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                hasConfig.add(((String)key).replace(".font", ""));
                UIManager.put(key, font);
            }
        }
    }
}
