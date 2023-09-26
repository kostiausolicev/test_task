package ru.kosti.screens;

import ru.kosti.MainFrame;

import javax.swing.*;
import java.awt.*;

public class FinalScreen extends JPanel {
    private final MainFrame frame;

    public FinalScreen(MainFrame parent) {
        this.frame = parent;
        this.setFocusable(true);
        this.requestFocus();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Font font = new Font("Arial", Font.BOLD, 24);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(font);

        FontMetrics fontMetrics = g2d.getFontMetrics();
        String text = "Вы проиграли";
        int textWidth = fontMetrics.stringWidth(text);
        int textHeight = fontMetrics.getHeight();

        int x = (getWidth() - textWidth) / 2;
        int y = (getHeight() - textHeight) / 2 - fontMetrics.getAscent();

        g2d.setColor(Color.BLACK);
        g2d.drawString(text, x, y);
    }
}
