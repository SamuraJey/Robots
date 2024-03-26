package viewmodel;

import model.Entity;

import java.util.ArrayList;
import java.util.List;

public class DefaultEntitiesGetter implements EntitiesGetter {
    private final List<Entity> registeredEntities = new ArrayList<>();

    public void register(Entity entity) {
        registeredEntities.add(entity);
    }

    @Override
    public List<Entity> getEntities() {
        return registeredEntities;
    }
}
