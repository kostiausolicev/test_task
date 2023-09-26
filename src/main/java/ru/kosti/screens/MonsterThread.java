package ru.kosti.screens;

import ru.kosti.entities.extended.Monster;
import ru.kosti.entities.extended.Player;

import javax.swing.*;
import java.util.Random;

public class MonsterThread extends Thread {
    private final Player player;
    private final JPanel panel;
    private Monster monster;

    public MonsterThread(Player player, JPanel panel) {
        this.player = player;
        this.panel = panel;
        monster = new Monster(1, 5, 1, 3, 10, 1);
    }

    @Override
    public void run() {
        final Random random = new Random();
        while (!player.isDead()) {
            while (!monster.isDead()) {
                int r = random.nextInt(10) + 1;
                if (r > 7) monster.hit(player);
                else if (r < 3) monster.block();
                if (player.isDead()) return;
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                panel.repaint();
            }
            monster = monster.update();
        }
    }

    public Monster getMonster() {
        return monster;
    }
}
