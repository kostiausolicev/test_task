package ru.kosti.entities.extended;

import ru.kosti.entities.AbstractEntity;

public class Player extends AbstractEntity {
    protected Player(int health, int defensive, int offensive, int damageLeft, int damageRight) {
        super(health, defensive, offensive, damageLeft, damageRight);
    }
}
