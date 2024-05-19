package view.renderers;

import model.entities.Food;
import model.entities.Entity;
import view.GraphicsUtils;

import java.awt.*;

public class FoodRenderer extends AbstractRenderer{
    @Override
    public void render(Graphics2D g, Entity entity) {
        Food food = (Food) entity;
        int foodX = GraphicsUtils.round(food.getFoodPosition().x);
        int foodY = GraphicsUtils.round(food.getFoodPosition().y);
        int foodWeight = food.getFoodWeight();
        int foodHeight = food.getFoodHeight();
        Color color = Color.GREEN;
        //AffineTransform t = AffineTransform.getRotateInstance(bacteria.getBacteriaDirection(), robotCenterX, robotCenterY);
        //g.setTransform(t);
        g.setColor(color);
        GraphicsUtils.fillRect(g, foodX, foodY, foodHeight, foodWeight);
    }
}
