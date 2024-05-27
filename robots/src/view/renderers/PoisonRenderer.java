package view.renderers;

import model.entities.PoisonEntity;
import model.entities.Entity;
import view.GraphicsUtils;

import java.awt.*;

public class PoisonRenderer extends AbstractRenderer{
    @Override
    public void render(Graphics2D g, Entity entity) {
        PoisonEntity poison = (PoisonEntity) entity;
        int poisonX = poison.getPoisonHeight() * GraphicsUtils.round(poison.getPosition().x / poison.getPoisonHeight());
        int poisonY = poison.getPoisonWidth() * GraphicsUtils.round(poison.getPosition().y / poison.getPoisonWidth());
        int poisonWidth = poison.getPoisonWidth();
        int poisonHeight = poison.getPoisonHeight();
        g.setColor(Color.RED);
        GraphicsUtils.fillRect(g, poisonX, poisonY, poisonHeight, poisonWidth);
        g.setColor(Color.BLACK);
        GraphicsUtils.drawRect(g, poisonX, poisonY, poisonHeight, poisonWidth);
    }
}