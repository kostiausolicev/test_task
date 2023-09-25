package ru.kosti.entities.extended;

import ru.kosti.entities.AbstractEntity;

public class Monster extends AbstractEntity {
    public Monster(int defensive, int offensive, int damageLeft, int damageRight, int maxHealth) {
        super(defensive, offensive, damageLeft, damageRight, maxHealth, "monster1_default.png");
    }
}
