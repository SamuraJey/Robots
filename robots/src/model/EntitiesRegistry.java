package model;

import model.entities.Entity;
import model.entities.Grid;

import java.util.List;

public interface EntitiesRegistry {
    List<Entity> getEntities();
    void register(Entity entity);

    Entity getEntity(Class<?> entityClass);
}
