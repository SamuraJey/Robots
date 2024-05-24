package model;

import model.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class DefaultEntitiesRegistry implements EntitiesRegistry {
    private final List<Entity> registeredEntities = new ArrayList<>();
    private final List<Entity> deleteEntity = new ArrayList<>();
    public void register(Entity entity) {
        registeredEntities.add(entity);
    }

    @Override
    public List<Entity> getEntities() {
        return registeredEntities;
    }

    public void delete() {
        for (Entity entity: deleteEntity){
            registeredEntities.remove(entity);
        }
        deleteEntity.clear();
    }

    public void addEntityToDelete(Entity entity){
        deleteEntity.add(entity);
    }
}
