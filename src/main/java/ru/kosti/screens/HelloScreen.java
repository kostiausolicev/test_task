package ru.kosti.screens;

import ru.kosti.MainFrame;
import ru.kosti.Utils;

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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Utils.drawText(24, "Добро пожаловать! Нажмите для старта", this, (Graphics2D) g);
    }
}
