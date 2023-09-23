package ru.kosti.screens;

import javax.swing.*;
import java.awt.*;

public class HelloScreen extends JPanel {
    private final JFrame frame;

    public HelloScreen(JFrame parent) {
        frame = parent;
        this.setLayout(new CardLayout());
        JButton button = new JButton();
        button.setText("Начать игру");
        button.addActionListener(e -> {
            var cl = (CardLayout)frame.getContentPane().getLayout();
            cl.show(frame.getContentPane(), "Game");
        });
        this.add(button);
        // TODO Сделать обработку кнопок
    }
}
