package model;

import model.entities.Entity;

import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.List;

public class Grid extends AbstractGrid implements EntitiesRegistry {

    HashMap<Point2D, Entity> entities = new HashMap<>();
    @Override
    public Entity getEntity(Point2D position) {

        return entities.get(position);
    }

    @Override
    public void setEntity(Entity entity) {
        entities.put(entity.getPosition(), entity);
    }

    @Override
    public void deleteEntity(Entity entity) {
        entities.remove(entity.getPosition());
    }

    @Override
    public List<Entity> getEntities() {
        return (List<Entity>) entities.values();
    }

    @Override
    public void register(Entity entity) {
        setEntity(entity);
    }
}
