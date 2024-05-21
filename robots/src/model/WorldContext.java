package model;

import model.entities.Entity;

import java.util.List;

public class WorldContext {
    private final Model model;

    public WorldContext(Model model) {
        this.model = model;
    }

    public void move(Entity entity, Direction direction)
    {
        // TODO
    }

    public <T extends Entity> List<T> findEntities(Class<T> entityType)
    {
        // TODO
        return null;
    }

    public enum Direction
    {
        // TODO
        UP(1,0 ),
        DOWN(-1,1 ),
        LEFT(-1,0 ),
        RIGHT(0,-1 );

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
}
