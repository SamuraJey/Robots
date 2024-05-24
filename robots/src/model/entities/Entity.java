package model.entities;

import model.WorldContext;

import java.awt.geom.Point2D;

public abstract class Entity {
    public abstract void update(WorldContext worldContext);

    public Point2D.Double getPosition() {
        return null;
    }
}
