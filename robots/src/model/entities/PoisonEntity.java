package model.entities;

import model.WorldContext;
import java.awt.geom.Point2D;
import java.util.List;

public class PoisonEntity extends Entity {
    private final Point2D.Double poisonPosition;
    private final int poisonHeight;
    private final int poisonWidth;

    public PoisonEntity(int width, int height, Point2D.Double position) {
        poisonWidth = width;
        poisonHeight = height;
        poisonPosition = position;
    }

    @Override
    public Point2D.Double getPosition() {
        return poisonPosition;
    }

    public int getPoisonHeight() {
        return poisonHeight;
    }

    public int getPoisonWidth() {
        return poisonWidth;
    }

    @Override
    public void update(WorldContext worldContext) {
        // Get all bacteria entities from the world context
        /*List<BacteriaEntity> bacteriaEntities = worldContext.findEntities(BacteriaEntity.class);

        // Iterate over all bacteria entities
        for (BacteriaEntity bacteria : bacteriaEntities) {
            // Check if the bacteria's position is the same as the poison's position
            if (bacteria.getPosition().equals(this.getPosition())) {
                // TODO - Как удалить бактерию то?
                worldContext.getModel().getEntities().remove(bacteria);
            }
        }*/
    }
}