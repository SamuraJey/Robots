package model.entities;

import model.DefaultEntitiesRegistry;
import model.EntitiesRegistry;
import model.MathUtils;

import java.awt.geom.Point2D;
import java.util.List;

public class BacteriaEntity extends Entity {

    private final FoodEntity food;
    private Point2D.Double bacteriaPosition = new Point2D.Double(0, 0);
    private final int bacteriaHeight;
    private final int bacteriaWeight;
    private final int countOfWidth;
    private final int countOfHeight;
    private final DefaultEntitiesRegistry entitiesRegistry;
    private boolean foodIsDel = false;

    private final List<String> listOfPosition = List.of("up","down","left","right");

    public BacteriaEntity(DefaultEntitiesRegistry entitiesRegistry, FoodEntity food, int weight, int height, int countOfWidth, int countOfHeight) {
        bacteriaHeight = height;
        bacteriaWeight = weight;
        this.countOfWidth = countOfWidth;
        this.countOfHeight = countOfHeight;
        this.food = food;
        this.entitiesRegistry = entitiesRegistry;
    }

    public Point2D.Double getBacteriaPosition() {
        return bacteriaPosition;
    }
    public int getBacteriaHeight(){ return  bacteriaHeight; }
    public int getBacteriaWeight(){ return  bacteriaWeight; }

    @Override
    public void update(int period) {
        if (foodIsDel){
            return;
        }

        if (bacteriaPosition.x == food.getFoodPosition().x && bacteriaPosition.y == food.getFoodPosition().y){
            entitiesRegistry.addEntityToDelete(food);
            foodIsDel = true;
            return;
        }
        String randomDirection = listOfPosition.get(MathUtils.getRandomNumber(4));
        bacteriaPosition = getNewBacteriaPosition(randomDirection);
    }



    private Point2D.Double getNewBacteriaPosition(String direction){
        int oldX = (int) bacteriaPosition.x;
        int oldY = (int) bacteriaPosition.y;
        int maxX = bacteriaHeight * (countOfHeight - 1);
        int maxY = bacteriaWeight * (countOfWidth - 1);
        int newX = 0;
        int newY = 0;

        if (direction.equals("up")){
            newX = oldX - bacteriaHeight;
            newY = oldY;
            if (newX < 0){
                newX = oldX;
            }
        }

        if (direction.equals("down")){
            newX = oldX + bacteriaHeight;
            newY = oldY;
            if (newX > maxX){
                newX = oldX;
            }
        }

        if (direction.equals("left")){
            newX = oldX;
            newY = oldY - bacteriaWeight;

            if (newY < 0){
                newY = oldY;
            }
        }

        if (direction.equals("right")){
            newX = oldX;
            newY = oldY + bacteriaWeight;
            if (newY > maxY){
                newY = oldY;
            }
        }

        return new Point2D.Double(newX,newY);
    }
    /*public void update(int period) {
        double distance = MathUtils.distance(m_target.x(), m_target.y(),
                m_robotPosition.x, m_robotPosition.y);
        if (distance < 0.5) {
            return;
        }
        double velocity = maxVelocity;
        double angleToTarget = MathUtils.angleTo(m_robotPosition.x, m_robotPosition.y, m_target.x(), m_target.y());
        double angularVelocity = 0;
        if (angleToTarget > m_robotDirection) {
            angularVelocity = maxAngularVelocity;
        }
        if (angleToTarget < m_robotDirection) {
            angularVelocity = -maxAngularVelocity;
        }

        moveRobot(velocity, angularVelocity, period);
    }

    private void moveRobot(double velocity, double angularVelocity, double duration) {
        velocity = MathUtils.applyLimits(velocity, 0, maxVelocity);
        angularVelocity = MathUtils.applyLimits(angularVelocity, -maxAngularVelocity, maxAngularVelocity);
        double newX = m_robotPosition.x + velocity / angularVelocity *
                (Math.sin(m_robotDirection + angularVelocity * duration) -
                        Math.sin(m_robotDirection));
        if (!Double.isFinite(newX)) {
            newX = m_robotPosition.x + velocity * duration * Math.cos(m_robotDirection);
        }
        double newY = m_robotPosition.y - velocity / angularVelocity *
                (Math.cos(m_robotDirection + angularVelocity * duration) -
                        Math.cos(m_robotDirection));
        if (!Double.isFinite(newY)) {
            newY = m_robotPosition.y + velocity * duration * Math.sin(m_robotDirection);
        }
        m_robotPosition.x = newX;
        m_robotPosition.y = newY;
        double newDirection = MathUtils.asNormalizedRadians(m_robotDirection + angularVelocity * duration);
        m_robotDirection = newDirection;
    }*/

}
