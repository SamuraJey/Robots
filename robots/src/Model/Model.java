package Model;

import java.util.List;

public class Model {
    private List<Entity> entities;

    public void update() {
        for (Entity entity : entities) {
            entity.update();
        }
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setTarget(float x, float y) {

    }
}
