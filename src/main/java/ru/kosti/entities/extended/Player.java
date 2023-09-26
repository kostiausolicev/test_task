package ru.kosti.entities.extended;

import ru.kosti.entities.AbstractEntity;

public class Player extends AbstractEntity {
    private int healingAmount = 4;

    public Player(int defensive, int offensive, int damageLeft, int damageRight, int maxHealth) {
        super(defensive, offensive, damageLeft, damageRight, maxHealth, "player_default.jpg");
    }

    public void healing() {
        if (healingAmount <= 0 || this.getHealth() == this.getMaxHealth()) {
            return;
        }
        healingAmount--;
        int currentHealth = ((int)(this.getMaxHealth() * 0.3) + this.getHealth());
        this.setHealth(currentHealth - (currentHealth >= this.getMaxHealth() ? currentHealth % this.getMaxHealth() : 0));
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    @Override
    public Player update() {
        healingAmount = 4;
        this.setMaxHealth((int)((double)this.getHealth() * 1.5));
        this.setHealth(this.getMaxHealth());
        return this;
    }
}
