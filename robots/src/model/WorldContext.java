package model;

import model.entities.BacteriaEntity;
import model.entities.Entity;
import model.entities.FoodEntity;
import model.entities.PoisonEntity;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class WorldContext {
    private final Model model;
    public WorldContext(Model model) {
        this.model = model;
    }

    public void moveBacteria(BacteriaEntity bacteria, Direction direction)
    {
        Point2D.Double oldPosition = bacteria.getPosition();
        Point2D.Double newPosition = new Point2D.Double();
        newPosition.x = oldPosition.x + direction.getxOffset() * model.getCellWidth();
        newPosition.y = oldPosition.y + direction.getyOffset() * model.getCellHeight();
        int maxX = model.getCellWidth() * (model.getCellCountWidth() - 1);
        int maxY = model.getCellHeight() * (model.getCellCountHeight() - 1);

        if (newPosition.x < 0 || newPosition.x > maxX || newPosition.y < 0 || newPosition.y > maxY){
            return;
        }
        Entity entityNearby = getEntityOfPosition(newPosition);

        if (entityNearby instanceof FoodEntity){
            model.entitiesRegistry.addEntityToDelete(entityNearby);
            bacteria.setPosition(newPosition);
        }

        if (entityNearby instanceof PoisonEntity){
            model.entitiesRegistry.addEntityToDelete(bacteria);
            model.entitiesRegistry.addEntityToDelete(entityNearby);
        }

        if (entityNearby == null){
            bacteria.setPosition(newPosition);
        }
    }



    public <T extends Entity> List<T> findEntities(Class<T> entityType)
    {
        List<T> entities = new ArrayList<>();
        for (Entity entity : model.getEntities()) {
            if (entityType.isInstance(entity)) {
                entities.add(entityType.cast(entity));
            }
        }
        return entities;
    }

    public enum Direction
    {
        UP(1,0 ),
        DOWN(-1,0 ),
        LEFT(0,-1 ),
        RIGHT(0,1 );

        private final int xOffset;
        private final int yOffset;

        Direction(int xOffset, int yOffset) {
            this.xOffset = xOffset;
            this.yOffset = yOffset;
        }

        public int getxOffset() {
            return xOffset;
        }

        public int getyOffset() {
            return yOffset;
        }

    }

    private Entity getEntityOfPosition(Point2D.Double position) {
        for (Entity entity : model.getEntities()) {
            if (position.equals(entity.getPosition())) {
                return entity;
            }
        }
        return null;
    }

    public Model getModel() {
        return model;
    }
}
