package View;

import Model.Entity;

import java.awt.*;

public interface Renderer<E extends Entity> {
    Class<?> getLinkedEntityType();
    void render(E entity, Graphics graphics);
}
