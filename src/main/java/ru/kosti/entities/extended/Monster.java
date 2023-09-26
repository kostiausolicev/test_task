package ru.kosti.entities.extended;

import ru.kosti.entities.AbstractEntity;

public class Monster extends AbstractEntity {
    private int index;

    public Monster(int defensive, int offensive, int damageLeft, int damageRight, int maxHealth, int index) {
        super(defensive * index, offensive * index / 2, damageLeft * index, damageRight * index, maxHealth * index, "monster" + index + ".png");
        this.index = index;
    }

    @Override
    public Monster update() {
        index++;
        return new Monster(this.defensive, this.offensive, this.damageLeft, this.damageRight, this.maxHealth, index);
    }

    public int getIndex() {
        return index;
    }
}
