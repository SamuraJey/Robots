package view.renderers;

import model.entities.FoodEntity;
import model.entities.Entity;
import view.GraphicsUtils;

import java.awt.*;

public class FoodRenderer extends AbstractRenderer{
    @Override
    public void render(Graphics2D g, Entity entity) {
        FoodEntity food = (FoodEntity) entity;
        int foodX = food.getFoodHeight() * GraphicsUtils.round(food.getPosition().x / food.getFoodHeight());
        int foodY = food.getFoodWidth() * GraphicsUtils.round(food.getPosition().y / food.getFoodWidth());
        int foodWidth = food.getFoodWidth();
        int foodHeight = food.getFoodHeight();
        Color color = Color.GREEN;
        //AffineTransform t = AffineTransform.getRotateInstance(bacteria.getBacteriaDirection(), robotCenterX, robotCenterY);
        //g.setTransform(t);
        g.setColor(color);
        GraphicsUtils.fillRect(g, foodX, foodY, foodHeight, foodWidth);
    }
}
