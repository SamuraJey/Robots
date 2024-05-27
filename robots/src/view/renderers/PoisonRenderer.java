package view.renderers;

import model.entities.Entity;
import model.entities.FoodEntity;
import model.entities.PoisonEntity;
import view.GraphicsUtils;

import java.awt.*;

public class PoisonRenderer extends AbstractRenderer{
    @Override
    public void render(Graphics2D g, Entity entity) {
        PoisonEntity poison = (PoisonEntity) entity;
        int poisonX = GraphicsUtils.round(poison.getPosition().x);
        int poisonY = GraphicsUtils.round(poison.getPosition().y);
        int poisonWidth = poison.getPoisonWidth();
        int poisonHeight = poison.getPoisonHeight();
        //AffineTransform t = AffineTransform.getRotateInstance(bacteria.getBacteriaDirection(), robotCenterX, robotCenterY);
        //g.setTransform(t);
        g.setColor(Color.RED);
        GraphicsUtils.fillRect(g, poisonX, poisonY, poisonHeight, poisonWidth);
        g.setColor(Color.BLACK);
        GraphicsUtils.drawRect(g,poisonX,poisonY,poisonHeight,poisonWidth);
    }
}
