package ru.kosti;

import ru.kosti.entities.extended.Monster;
import ru.kosti.entities.extended.Player;
import ru.kosti.screens.GameScreen;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MonsterThread extends Thread {
    private final Font font;
    private final Player player;
    private final GameScreen panel;
    private Monster monster;

    public MonsterThread(Player player, JPanel panel) {
        this.player = player;
        this.panel = (GameScreen) panel;
        monster = new Monster(1, 5, 1, 3, 10, 1);
        font = new Font("Aria", Font.BOLD, 12);
    }

    @Override
    public void run() {
        final Random random = new Random();
        while (!player.isDead()) {
            while (!monster.isDead()) {
                int r = random.nextInt(10) + 1;
                if (r > 7) {
                    monster.hit(player);
                    panel.setMonsterActionString("Монстр ударил игрока");
                }
                else if (r < 3) {
                    monster.block();
                    panel.setMonsterActionString("Монстр заблокировал удар");
                }
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
