package view.renderers;

import model.entities.FoodEntity;
import model.entities.Entity;
import view.GraphicsUtils;

import java.awt.*;

public class FoodRenderer extends AbstractRenderer{
    @Override
    public void render(Graphics2D g, Entity entity) {
        FoodEntity food = (FoodEntity) entity;
        int foodX = GraphicsUtils.round(food.getPosition().x);//food.getFoodHeight() * GraphicsUtils.round(food.getPosition().x / food.getFoodHeight());
        int foodY = GraphicsUtils.round(food.getPosition().y);//food.getFoodWidth() * GraphicsUtils.round(food.getPosition().y / food.getFoodWidth());
        int foodWidth = food.getFoodWidth();
        int foodHeight = food.getFoodHeight();
        //AffineTransform t = AffineTransform.getRotateInstance(bacteria.getBacteriaDirection(), robotCenterX, robotCenterY);
        //g.setTransform(t);
        g.setColor(Color.GREEN);
        GraphicsUtils.fillRect(g, foodX, foodY, foodHeight, foodWidth);
        g.setColor(Color.BLACK);
        GraphicsUtils.drawRect(g,foodX,foodY,foodHeight,foodWidth);
    }
}
