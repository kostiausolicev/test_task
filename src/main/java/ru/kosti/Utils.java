package ru.kosti;

import javax.swing.*;
import java.awt.*;

public class Utils {
    // Для текста по центру экрана
    public static void drawText(int textSize, String text, JPanel component, Graphics2D g2d) {
        Font font = new Font("Arial", Font.BOLD, textSize);
        g2d.setFont(font);

        FontMetrics fontMetrics = g2d.getFontMetrics();
        int textWidth = fontMetrics.stringWidth(text);
        int textHeight = fontMetrics.getHeight();

        int x = (component.getWidth() - textWidth) / 2;
        int y = (component.getHeight() - textHeight) / 2 - fontMetrics.getAscent();

        g2d.setColor(Color.BLACK);
        g2d.drawString(text, x, y);
    }

}
