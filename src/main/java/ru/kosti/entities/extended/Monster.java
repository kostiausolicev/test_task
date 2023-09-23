package ru.kosti.entities.extended;

import ru.kosti.entities.AbstractEntity;

public class Monster extends AbstractEntity {
    public Monster(int health, int defensive, int offensive, int damageLeft, int damageRight, int maxHealth) {
        super(health, defensive, offensive, damageLeft, damageRight, maxHealth);
    }
}
