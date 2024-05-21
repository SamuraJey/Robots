package model.entities;

import model.WorldContext;

public abstract class Entity {
    public abstract void update(int period, WorldContext worldContext);
}
