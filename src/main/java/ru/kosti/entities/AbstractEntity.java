package ru.kosti.entities;

import ru.kosti.Main;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class AbstractEntity {
    private static final Random random = new Random();
    protected final int defensive;
    protected final int offensive;
    protected final int damageLeft;
    protected final int damageRight;
    protected int maxHealth;
    protected Image skin;
    protected int health;
    protected boolean block;

    protected AbstractEntity(int defensive, int offensive, int damageLeft, int damageRight, int maxHealth, String fileName) {
        if (maxHealth <= 0) throw new IllegalArgumentException("Maximum health must be greater than 0");
        if (defensive < 0 | offensive < 0 | damageLeft < 0 | damageRight < 0) throw new IllegalArgumentException("You enter not correct args");
        this.health = maxHealth;
        this.defensive = defensive;
        this.offensive = offensive;
        this.damageLeft = damageLeft;
        this.damageRight = damageRight;
        this.maxHealth = maxHealth;
        try {
            this.skin = new ImageIcon(Main.class.getClassLoader().getResource(fileName)).getImage();
        } catch (NullPointerException e) {
            this.skin = new ImageIcon(Main.class.getClassLoader().getResource("default.jpg")).getImage();
        }
    }

    public abstract AbstractEntity update();

    public void block() {
        this.block = true;
    }

    public void hit(AbstractEntity entity) {
        if (block) {
            block = false;
            return;
        }
        if (entity.block) {
            entity.block = false;
            return;
        }
        var successHit = false;
        int offensiveModifier = Math.abs(this.getOffensive() - entity.getDefensive()) + 1;
        for (int i = 0; i < offensiveModifier; i++) {
            if (random.nextInt(6) + 1 >= 5) {
                successHit = true;
                break;
            }
        }
        if (!successHit) return;

        entity.takingDamage(random.nextInt(this.damageRight - this.damageLeft) + this.damageLeft + 1);
    }

    private void takingDamage(int damage) {
        this.health -= damage;
    }

    public boolean isDead() {
        return this.getHealth() <= 0;
    }

    public int getHealth() {
        return health;
    }

    public int getDefensive() {
        return defensive;
    }

    public int getOffensive() {
        return offensive;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public Image getSkin() {
        return skin;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
}
