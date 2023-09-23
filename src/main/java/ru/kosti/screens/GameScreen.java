package ru.kosti.screens;

import ru.kosti.entities.AbstractEntity;
import ru.kosti.entities.extended.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameScreen extends JPanel {
    private final ArrayList<AbstractEntity> monsters = new ArrayList<>();
    private final Player player = new Player(1, 1, 1, 1, 1, 1);
    private final JFrame frame;

    public GameScreen(final JFrame parent) {
        setFocusable(true);
        frame = parent;
        // TODO добавить обработку кнопок
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
    }
}
