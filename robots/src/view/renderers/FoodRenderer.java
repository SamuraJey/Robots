package view.renderers;

import model.entities.FoodEntity;
import model.entities.Entity;
import view.GraphicsUtils;

import java.awt.*;

public class FoodRenderer extends AbstractRenderer{
    @Override
    public void render(Graphics2D g, Entity entity) {
        FoodEntity food = (FoodEntity) entity;
        int foodX = GraphicsUtils.round(food.getPosition().x);
        int foodY = GraphicsUtils.round(food.getPosition().y);
        int foodWidth = food.getFoodWidth();
        int foodHeight = food.getFoodHeight();
        Color color = Color.GREEN;
        //AffineTransform t = AffineTransform.getRotateInstance(bacteria.getBacteriaDirection(), robotCenterX, robotCenterY);
        //g.setTransform(t);
        g.setColor(color);
        GraphicsUtils.fillRect(g, foodX, foodY, foodHeight, foodWidth);
    }
}
