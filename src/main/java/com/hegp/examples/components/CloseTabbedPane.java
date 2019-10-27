package com.hegp.examples.components;

import javax.swing.*;

public class CloseTabbedPane extends JTabbedPane {

    public CloseTabbedPane() {
        super.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    public void addTabbedItem(CloseTabbedItem tabbedItem) {
        tabbedItem.setTabbedPane(this);

        tabbedItem.init();
    }

    public void addTabbedItem(JPanel contentPane, String tabHeaderTitle) {
        addTabbedItem(new CloseTabbedItem(new JPanel(), tabHeaderTitle));
    }

}
