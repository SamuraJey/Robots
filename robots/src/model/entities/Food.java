package model.entities;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;
import java.util.Random;

public class Food extends Entity{
    private final Point2D.Double foodPosition;
    private final int foodHeight;
    private final int foodWeight;
    private final int countOfWidth;
    private final int countOfHeight;
    public Food(int weight, int height, int countOfWidth, int countOfHeight) {
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
        int randomWidth = rn.nextInt(countOfWidth);
        int randomHeight = rn.nextInt(countOfHeight);
        double foodX = foodHeight * randomHeight;
        double foodY = foodWeight * randomWidth;
        return new Point2D.Double(foodX,foodY);
    }
    @Override
    public void update(int period) {

    }
}
