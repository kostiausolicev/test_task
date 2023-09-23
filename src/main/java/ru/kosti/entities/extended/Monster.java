package ru.kosti.entities.extended;

import ru.kosti.entities.AbstractEntity;

public class Monster extends AbstractEntity {
    protected Monster(int health, int defensive, int offensive, int damageLeft, int damageRight) {
        super(health, defensive, offensive, damageLeft, damageRight);
    }
}
