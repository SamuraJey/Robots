package model.entities;

import java.awt.geom.Point2D;

public abstract class Entity {
    private Point2D position;

    public abstract void update();


    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }
}
