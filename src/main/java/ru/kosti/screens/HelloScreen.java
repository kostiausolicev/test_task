package ru.kosti.screens;

import ru.kosti.MainFrame;

import javax.swing.*;
import java.awt.*;

public class HelloScreen extends JPanel {
    private final MainFrame frame;

    public HelloScreen(JFrame parent) {
        frame = (MainFrame) parent;
        this.setLayout(new BorderLayout());

        JLabel label = new JLabel("Добро пожаловать! Нажмите для старта");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        this.add(label, BorderLayout.NORTH);

        JButton button = new JButton();
        button.setText("Начать игру");
        button.addActionListener(e -> {
            frame.showPanel("Game");
        });
        this.add(button, BorderLayout.CENTER);
    }
}
