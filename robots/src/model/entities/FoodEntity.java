package model.entities;

import model.MathUtils;

import java.awt.geom.Point2D;
import java.util.Random;

public class FoodEntity extends Entity{
    private final Point2D.Double foodPosition;
    private final int foodHeight;
    private final int foodWidth;
    private final int countOfWidth;
    private final int countOfHeight;
    public FoodEntity(int weight, int height, int countOfWidth, int countOfHeight) {
        foodWidth = weight;
        foodHeight = height;
        this.countOfWidth = countOfWidth;
        this.countOfHeight = countOfHeight;
        foodPosition = getPosition();
    }

    public Point2D.Double getFoodPosition() {
        return foodPosition;
    }

    public int getFoodHeight(){ return  foodHeight; }
    public int getFoodWidth(){ return  foodWidth; }

    private Point2D.Double getPosition(){
        int randomWidth = MathUtils.getRandomNumber(countOfWidth);
        int randomHeight = MathUtils.getRandomNumber(countOfHeight);
        double foodX = foodHeight * randomHeight;
        double foodY = foodWidth * randomWidth;
        return new Point2D.Double(foodX,foodY);
    }
    @Override
    public void update(int period) {

    }
}
