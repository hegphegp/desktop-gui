package com.hegp.examples.components;

import javax.swing.*;
import java.awt.*;

public class CloseTabIcon implements Icon {
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	public CloseTabIcon() {
		width = 16;
		height = 16;
	}
 
	public void paintIcon(Component c, Graphics g, int x, int y) {
		this.xPos = x;
		this.yPos = y;
		Color col = g.getColor();
		g.setColor(Color.black);
		int y_p = y + 2;
		g.drawLine(x + 1, y_p, x + 12, y_p);
		g.drawLine(x + 1, y_p + 13, x + 12, y_p + 13);
		g.drawLine(x, y_p + 1, x, y_p + 12);
		g.drawLine(x + 13, y_p + 1, x + 13, y_p + 12);
		g.drawLine(x + 3, y_p + 3, x + 10, y_p + 10);
		g.drawLine(x + 3, y_p + 4, x + 9, y_p + 10);
		g.drawLine(x + 4, y_p + 3, x + 10, y_p + 9);
		g.drawLine(x + 10, y_p + 3, x + 3, y_p + 10);
		g.drawLine(x + 10, y_p + 4, x + 4, y_p + 10);
		g.drawLine(x + 9, y_p + 3, x + 3, y_p + 9);
		g.setColor(col);
	}
 
	public int getIconWidth() {
		return width;
	}
 
	public int getIconHeight() {
		return height;
	}
 
	public Rectangle getBounds() {
		return new Rectangle(xPos, yPos, width, height);
	}
}