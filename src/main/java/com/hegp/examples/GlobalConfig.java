package com.hegp.examples;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

public class GlobalConfig {
    //设置系统样式
    public static void setCurrentSystemStyle() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setNimbusLookAndFeelStyl1e() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setUIFont() {
        FontUIResource font = new FontUIResource("微软雅黑", Font.BOLD, 18);


//        /*
//         * 统一所有子窗口设置字体样式
//         */
//        FontUIResource fontRes = new FontUIResource(new Font("微软雅黑", Font.BOLD, 18));
//        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
//            Object key = keys.nextElement();
//            if (key instanceof String && (((String)key).endsWith("font") || ((String)key).endsWith("Font"))) {
//                System.out.println(key);
//            }
//            Object value = UIManager.get(key);
//            if (value instanceof FontUIResource) {
//                System.out.println("=========="+key);
//                UIManager.put(key, font);
//            }
//        }

        String names[]={ "Label", "CheckBox", "PopupMenu","MenuItem", "CheckBoxMenuItem", "JComponent",
                "JRadioButtonMenuItem", "ComboBox", "Button", "Tree", "ScrollPane", "JLabel", "JPanel",
                "TabbedPane", "EditorPane", "TitledBorder", "Menu", "TextArea",
                "OptionPane", "MenuBar", "ToolBar", "ToggleButton", "ToolTip",
                "ProgressBar", "TableHeader", "Panel", "List", "ColorChooser",
                "PasswordField", "TextField", "Table", "Label", "Viewport",
                "RadioButtonMenuItem", "RadioButton", "DesktopPane", "InternalFrame"
        };

        for (String item : names) {
            UIManager.put(item + ".font", font);
        }

//        UIManager.put("ToolTip.font",font);
//        UIManager.put("Table.font",font);
//        UIManager.put("TableHeader.font",font);
//        UIManager.put("TextField.font",font);
//        UIManager.put("ComboBox.font",font);
//        UIManager.put("TextField.font",font);
//        UIManager.put("PasswordField.font",font);
//        UIManager.put("TextArea.font",font);
//        UIManager.put("TextPane.font",font);
//        UIManager.put("EditorPane.font",font);
//        UIManager.put("FormattedTextField.font",font);
//        UIManager.put("Button.font",font);
//        UIManager.put("CheckBox.font",font);
//        UIManager.put("RadioButton.font",font);
//        UIManager.put("ToggleButton.font",font);
//        UIManager.put("ProgressBar.font",font);
//        UIManager.put("DesktopIcon.font",font);
//        UIManager.put("TitledBorder.font",font);
//        UIManager.put("Label.font",font);
//        UIManager.put("List.font",font);
//        UIManager.put("TabbedPane.font",font);
//        UIManager.put("MenuBar.font",font);
//        UIManager.put("Menu.font",font);
//        UIManager.put("MenuItem.font",font);
//        UIManager.put("PopupMenu.font",font);
//        UIManager.put("CheckBoxMenuItem.font",font);
//        UIManager.put("RadioButtonMenuItem.font",font);
//        UIManager.put("Spinner.font",font);
//        UIManager.put("Tree.font",font);
//        UIManager.put("ToolBar.font",font);
//        UIManager.put("OptionPane.messageFont",font);
//        UIManager.put("OptionPane.buttonFont",font);
    }
}
