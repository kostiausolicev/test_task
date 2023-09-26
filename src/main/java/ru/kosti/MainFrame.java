package ru.kosti;

import ru.kosti.screens.GameScreen;
import ru.kosti.screens.HelloScreen;
import ru.kosti.screens.FinalScreen;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static final int WIGHT = 800;
    private static final int HEIGHT = 600;
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel cardPanel;

    public MainFrame(String title) {
        this.setTitle(title);
        this.setLayout(cardLayout);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(WIGHT, HEIGHT);
        cardPanel = new JPanel(cardLayout);
        cardPanel.add("Hello", new HelloScreen(this));
        cardPanel.add("Game", new GameScreen(this));
        cardPanel.add("Final", new FinalScreen(this));
        this.add(cardPanel);
    }

    public void showPanel(String panelName) {

        cardLayout.show(cardPanel, panelName);
    }

}
