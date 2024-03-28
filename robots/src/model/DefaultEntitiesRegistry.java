package model;

import model.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class DefaultEntitiesRegistry implements EntitiesRegistry {
    private final List<Entity> registeredEntities = new ArrayList<>();

    public void register(Entity entity) {
        registeredEntities.add(entity);
    }

    @Override
    public Entity getEntity(Class<?> entityClass) {
        for (Entity entity : registeredEntities){
            if (entity.getClass().equals(entityClass)) return entity;
        }
        return null;
    }

    @Override
    public List<Entity> getEntities() {
        return registeredEntities;
    }
}
