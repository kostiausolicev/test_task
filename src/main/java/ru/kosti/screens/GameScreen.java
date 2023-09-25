package ru.kosti.screens;

import ru.kosti.entities.extended.Monster;
import ru.kosti.entities.extended.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameScreen extends JPanel {
    private Monster monster;
    private final Player player;
    private final JFrame parent;
    private final Font font = new Font("Arial", Font.BOLD, 14);

    public GameScreen(final JFrame parent) {
        this.parent = parent;
        player = new Player(20, 20, 1, 20, 100);
        monster = new Monster(10, 10, 1, 5, 100, 1);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.requestFocus();
        this.start();
    }

    private void start() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                // TODO Сделать вывод последнего действия на экран посередине
                switch (e.getKeyChar()) {
                    case 'a' -> player.hit(monster);
                    case 'b' -> player.block();
                    case 'h' -> player.healing();
                }
                repaint();
            }
        });
        if (parent.getFocusOwner() == null) return;
        while (!player.isDead()) {
            System.out.println(11);
        }
    }

    private void drawPlayer(Graphics2D g2d) {
        int h = 250;
        int w = (int)(player.getSkin().getWidth(this) * ((double)h / player.getSkin().getHeight(this)));
        g2d.drawImage(player.getSkin(), 200 - w, (int)(parent.getHeight() * 0.8d) - h, w, h, this);
    }

    private void drawMonster(Graphics2D g2d) {
        int h = 250;
        int w = (int)(monster.getSkin().getWidth(this) * ((double)h / monster.getSkin().getHeight(this)));
        g2d.drawImage(monster.getSkin(), parent.getWidth() - 200, (int)(parent.getHeight() * 0.8d) - h, w, h, this);
    }

    private void drawHealthStatus(Graphics2D g2d) {
        // Здоровье игрока
        g2d.drawString("Здоровье игрока. Осталось " + player.getHealingAmount() + " аптечек", 5, 40);
        g2d.setColor(Color.WHITE);
        g2d.drawRect(5, 50, 200, 20);
        g2d.setColor(Color.BLACK);
        g2d.fillRect(5, 50, (int)(200 * ((double)player.getHealth() / player.getMaxHealth())), 20);

        // Здоровье монстра
        g2d.drawString("Здоровье монстра " + monster.getIndex(), parent.getWidth() - 220, 40);
        g2d.drawRect(parent.getWidth() - 220, 50, 200, 20);
        g2d.setColor(Color.BLACK);
        g2d.fillRect(parent.getWidth() - 220, 50, (int)(200 * ((double)monster.getHealth() / monster.getMaxHealth())), 20);
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
        drawHealthStatus(g2d);
        drawPlayer(g2d);
        drawMonster(g2d);
    }
}
