package model;

import model.entities.Entity;

import java.awt.geom.Point2D;

public abstract class AbstractGrid {
    public abstract Entity getEntity (Point2D position);
    public abstract void setEntity (Entity entity);
    public abstract void deleteEntity (Entity entity);
}
