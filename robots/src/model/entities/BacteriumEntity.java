package model.entities;

import java.awt.geom.Point2D;

public class BacteriumEntity extends Entity {

    private int health;

    public BacteriumEntity(int health, Point2D position) {
        this.health = health;
        super.setPosition(position);
    }

    @Override
    public void update() {

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
