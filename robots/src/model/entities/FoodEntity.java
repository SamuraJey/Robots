package model.entities;

import model.WorldContext;
import java.awt.geom.Point2D;

public class FoodEntity extends Entity {
    private final Point2D.Double foodPosition;
    private final int foodHeight;
    private final int foodWidth;
    // private final int countOfWidth;
    // private final int countOfHeight;

    public FoodEntity(int width, int height, Point2D.Double position) {
        foodWidth = width;
        foodHeight = height;
        foodPosition = position;
        // foodPosition = getFoodPosition();
    }

    @Override
    public Point2D.Double getPosition() {
        return foodPosition;
    }

    public int getFoodHeight() {
        return foodHeight;
    }

    public int getFoodWidth() {
        return foodWidth;
    }

    // private Point2D.Double getFoodPosition() {
    // int randomWidth = MathUtils.getRandomNumber(countOfWidth);
    // int randomHeight = MathUtils.getRandomNumber(countOfHeight);
    // double foodX = foodHeight * randomHeight;
    // double foodY = foodWidth * randomWidth;
    // return new Point2D.Double(foodX, foodY);
    // }

    @Override
    public void update(WorldContext worldContext) {

    }
}
