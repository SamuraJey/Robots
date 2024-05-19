package model.entities;

import model.MathUtils;

import java.awt.geom.Point2D;
import java.util.Random;

public class FoodEntity extends Entity{
    private final Point2D.Double foodPosition;
    private final int foodHeight;
    private final int foodWeight;
    private final int countOfWidth;
    private final int countOfHeight;
    public FoodEntity(int weight, int height, int countOfWidth, int countOfHeight) {
        foodWeight = weight;
        foodHeight = height;
        this.countOfWidth = countOfWidth;
        this.countOfHeight = countOfHeight;
        foodPosition = getPosition();
    }

    public Point2D.Double getFoodPosition() {
        return foodPosition;
    }

    public int getFoodHeight(){ return  foodHeight; }
    public int getFoodWeight(){ return  foodWeight; }

    private Point2D.Double getPosition(){
        Random rn = new Random();
        int randomWidth = MathUtils.getRandomNumber(countOfWidth);
        int randomHeight = MathUtils.getRandomNumber(countOfHeight);
        double foodX = foodHeight * randomHeight;
        double foodY = foodWeight * randomWidth;
        return new Point2D.Double(foodX,foodY);
    }
    @Override
    public void update(int period) {

    }
}
