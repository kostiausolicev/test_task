package ru.kosti;

import ru.kosti.screens.GameScreen;
import ru.kosti.screens.HelloScreen;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static final int WIGHT = 800;
    private static final int HEIGHT = 600;
    private static final JFrame frame;

    static {
        frame = new JFrame("Драка с монстрами");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new CardLayout());
        frame.setSize(WIGHT, HEIGHT);
        frame.setVisible(true);
        var container = frame.getContentPane();
        container.add("StartPage", new HelloScreen(frame));
        container.add("Game", new GameScreen(frame));
        // TODO Добавить экраны победы и проигрыша
    }

    public static void main(String[] args) {

    }
}
