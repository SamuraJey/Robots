package model.entities;

import model.MathUtils;
import model.WorldContext;

import java.awt.geom.Point2D;
import java.util.List;

public class BacteriaEntity extends Entity {
    private Point2D.Double bacteriaPosition = new Point2D.Double(0, 0);
    private final int bacteriaHeight;
    private final int bacteriaWidth;
    private final List<WorldContext.Direction> listOfDirection = List.of(WorldContext.Direction.UP, WorldContext.Direction.DOWN, WorldContext.Direction.LEFT, WorldContext.Direction.RIGHT);

    public BacteriaEntity(int width, int height) {
        bacteriaHeight = height;
        bacteriaWidth = width;
    }
    @Override
    public Point2D.Double getPosition() {
        return bacteriaPosition;
    }
    public int getBacteriaHeight(){ return  bacteriaHeight; }
    public int getBacteriaWidth(){ return  bacteriaWidth; }

    public void setPosition(Point2D.Double position) { bacteriaPosition = position; }

    @Override
    public void update(WorldContext worldContext) {
        List<FoodEntity> foodEntityList = worldContext.findEntities(FoodEntity.class);

        if (foodEntityList.isEmpty()){
            return;
        }
        WorldContext.Direction randomDirection = listOfDirection.get(MathUtils.getRandomNumber(4));
        worldContext.moveBacteria(this,randomDirection);
    }
}
