package ru.kosti.entities;

import java.util.Random;

public abstract class AbstractEntity {
    private static final Random random = new Random();
    protected final int defensive;
    protected final int offensive;
    protected final int damageLeft;
    protected final int damageRight;
    protected final int maxHealth;
    protected int health;

    protected AbstractEntity(int health, int defensive, int offensive, int damageLeft, int damageRight, int maxHealth) {
        this.health = health;
        this.defensive = defensive;
        this.offensive = offensive;
        this.damageLeft = damageLeft;
        this.damageRight = damageRight;
        this.maxHealth = maxHealth;
    }

    public boolean block() {
        return false;
        // TODO Сделать блокирование
    }

    public boolean hit(AbstractEntity entity) {
        var successHit = false;
        int offensiveModifier = this.getOffensive() - entity.getDefensive() + 1;
        for (int i = 0; i < offensiveModifier; i++) {
            if (random.nextInt(6) + 1 >= 5) {
                successHit = true;
                break;
            }
        }
        if (!successHit) return false;

        entity.takingDamage(random.nextInt(this.damageRight) + this.damageLeft);
        return true;
    }

    public void takingDamage(int damage) {
        this.health -= damage;
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

    public int getDamageLeft() {
        return damageLeft;
    }

    public int getDamageRight() {
        return damageRight;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}
