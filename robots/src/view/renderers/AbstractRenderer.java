package view.renderers;

import model.entities.Entity;

import java.awt.*;

public abstract class AbstractRenderer {
    public abstract void render(Graphics2D g, Entity entity);
}
