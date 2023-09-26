package ru.kosti.screens;

import ru.kosti.MainFrame;
import ru.kosti.entities.extended.Monster;
import ru.kosti.entities.extended.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameScreen extends JPanel {
    private final MonsterThread monsterActions;
    private final Player player;
    private final MainFrame frame;
    private final Font font = new Font("Arial", Font.BOLD, 14);

    public GameScreen(final JFrame frame) {
        this.frame = (MainFrame) frame;
        player = new Player(20, 20, 1, 20, 100);
        monsterActions = new MonsterThread(player, this);
        this.setFocusable(true);
        this.requestFocus();
        this.addListeners();
    }

    private void addListeners() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                // TODO Сделать вывод последнего действия на экран посередине
                switch (e.getKeyChar()) {
                    case 'a' -> player.hit(monsterActions.getMonster());
                    case 'b' -> player.block();
                    case 'h' -> player.healing();
                }
                repaint();
            }
        });

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                start();
            }
        });
    }

    private void start() {
        monsterActions.start();
    }

    private void drawPlayer(Graphics2D g2d) {
        int h = 250;
        int w = (int)(player.getSkin().getWidth(this) * ((double)h / player.getSkin().getHeight(this)));
        g2d.drawImage(player.getSkin(), 200 - w, (int)(frame.getHeight() * 0.8d) - h, w, h, this);
    }

    private void drawMonster(Graphics2D g2d) {
        int h = 250;
        int w = (int)(monsterActions.getMonster().getSkin().getWidth(this) * ((double)h / monsterActions.getMonster().getSkin().getHeight(this)));
        g2d.drawImage(monsterActions.getMonster().getSkin(), frame.getWidth() - 200, (int)(frame.getHeight() * 0.8d) - h, w, h, this);
    }

    private void drawHealthStatus(Graphics2D g2d) {
        // Здоровье игрока
        g2d.drawString("Здоровье игрока. Осталось " + player.getHealingAmount() + " аптечек", 5, 40);
        g2d.setColor(Color.WHITE);
        g2d.drawRect(5, 50, 200, 20);
        g2d.setColor(Color.BLACK);
        g2d.fillRect(5, 50, (int)(200 * ((double)player.getHealth() / player.getMaxHealth())), 20);

        // Здоровье монстра
        g2d.drawString("Здоровье монстра " + monsterActions.getMonster().getIndex(), frame.getWidth() - 220, 40);
        g2d.drawRect(frame.getWidth() - 220, 50, 200, 20);
        g2d.setColor(Color.BLACK);
        g2d.fillRect(frame.getWidth() - 220, 50, (int)(200 * ((double)monsterActions.getMonster().getHealth() / monsterActions.getMonster().getMaxHealth())), 20);
    }

    private void drawArea(Graphics2D g2d) {
        g2d.drawLine(0, 75, frame.getWidth(), 75);
        g2d.drawLine(0, (int)(frame.getHeight() * 0.8d), frame.getWidth(), (int)(frame.getHeight() * 0.8d));

        FontMetrics fontMetrics = g2d.getFontMetrics();
        String text = "Удар - A, Блок - B, Лечение H (английская раскладка) ";
        g2d.drawString(text, (frame.getWidth() - fontMetrics.stringWidth(text)) / 2, (int)(frame.getHeight() * 0.8d) + 40);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (player.isDead()) {
            monsterActions.interrupt();
            frame.showPanel("Final");
            return;
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(font);
        drawArea(g2d);
        drawHealthStatus(g2d);
        drawPlayer(g2d);
        drawMonster(g2d);
    }
}
