package model;

import model.entities.Entity;

public class Model {
    public final EntitiesRegistry entitiesRegistry;
    public final AbstractGrid grid;

    public Model() {
        AbstractGrid g = new Grid();
        entitiesRegistry = (EntitiesRegistry) g;
        grid = g;
        init();
    }
    public Model(ConfigEntities configEntities) {
        AbstractGrid g = new Grid();
        entitiesRegistry = (EntitiesRegistry) g;
        grid = g;
        init();
    }

    private void init() {
        // TODO

    }

    public void update() {
        for (Entity entity : entitiesRegistry.getEntities()) {
            entity.update();
        }
    }
}
