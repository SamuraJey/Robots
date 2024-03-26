package View.renderers;

import Model.Entity;

import java.awt.*;

public abstract class AbstractRenderer {
    public abstract void render(Graphics2D g, Entity entity);
}
