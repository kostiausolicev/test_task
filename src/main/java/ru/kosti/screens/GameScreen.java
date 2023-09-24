package ru.kosti.screens;

import ru.kosti.entities.extended.Monster;
import ru.kosti.entities.extended.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameScreen extends JPanel {
    private Monster monster;
    private int monsterIndex = 1;
    private final Player player;
    private final JFrame parent;
    private final Font font = new Font("Arial", Font.BOLD, 16);

    public GameScreen(final JFrame parent) {
        this.parent = parent;
        player = new Player(20, 20, 1, 20, 100);
        monster = new Monster(10 * monsterIndex, 10 * monsterIndex, monsterIndex, 5 * monsterIndex, 100 * monsterIndex);
        // TODO добавить обработку кнопок
    }

    private void drawPlayer(Graphics2D g2d) {

    }

    private void drawMonster(Graphics2D g2d) {

    }

    private void drawHealthStatus(Graphics2D g2d) {
        // Здоровье игрока
        g2d.drawString("Здоровье игрока", 5, 40);
        g2d.setColor(Color.WHITE);
        g2d.drawRect(5, 50, 200, 20);
        g2d.setColor(Color.BLACK);
        g2d.fillRect(5, 50, 200 * (player.getHealth() / player.getMaxHealth()), 20);

        // Здоровье монстра
        g2d.drawString("Здоровье монстра " + monsterIndex, parent.getWidth() - 220, 40);
        g2d.drawRect(parent.getWidth() - 220, 50, 200, 20);
        g2d.setColor(Color.BLACK);
        g2d.fillRect(parent.getWidth() - 220, 50, 200 * (monster.getHealth() / monster.getMaxHealth()), 20);
    }

    private void drawArea(Graphics2D g2d) {
        g2d.drawLine(0, 75, parent.getWidth(), 75);
        g2d.drawLine(0, (int)(parent.getHeight() * 0.8d), parent.getWidth(), (int)(parent.getHeight() * 0.8d));

        FontMetrics fontMetrics = g2d.getFontMetrics();
        String text = "Удар - A, Блок - B, Лечение H (английская раскладка) ";
        g2d.drawString(text, (parent.getWidth() - fontMetrics.stringWidth(text)) / 2, (int)(parent.getHeight() * 0.8d) + 40);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(font);
        drawArea(g2d);
        drawPlayer(g2d);
        drawMonster(g2d);
        drawHealthStatus(g2d);
    }
}
