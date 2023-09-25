package ru.kosti.screens;

import ru.kosti.MainFrame;

import javax.swing.*;
import java.awt.*;

public class HelloScreen extends JPanel {
    private final MainFrame frame;
    private final JButton button;

    public HelloScreen(JFrame parent) {
        frame = (MainFrame) parent;
        this.setFocusable(true);
        button = new JButton();
        button.setBounds(50, 50, 200, 100);
        button.setText("Начать игру");
        button.addActionListener(e -> {
            frame.getContentPane().remove(this);
            button.setFocusable(false);
            frame.showPanel("Game");
        });
        this.add(button);
    }

    private void drawText(Graphics2D g2d) {
        Font font = new Font("Arial", Font.BOLD, 24);
        g2d.setFont(font);

        FontMetrics fontMetrics = g2d.getFontMetrics();
        String text = "Добро пожаловать! Нажмите для старта";
        int textWidth = fontMetrics.stringWidth(text);
        int textHeight = fontMetrics.getHeight();

        int x = (getWidth() - textWidth) / 2;
        int y = (getHeight() - textHeight) / 2 - fontMetrics.getAscent();

        g2d.setColor(Color.BLACK);
        g2d.drawString(text, x, y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawText((Graphics2D) g);
//        button.paint(g);
    }
}
