package ru.kosti.entities.extended;

import ru.kosti.entities.AbstractEntity;

public class Player extends AbstractEntity {
    private int healingAmount = 4;

    public Player(int health, int defensive, int offensive, int damageLeft, int damageRight, int maxHealth) {
        super(health, defensive, offensive, damageLeft, damageRight, maxHealth);
    }

    public boolean healing() {
        if (healingAmount <= 0) {
            return false;
        }
        healingAmount--;
        this.setHealth((int)(this.getMaxHealth() * 0.3));
        return true;
    }
}
