package model.entities;

import java.awt.geom.Point2D;

public class TargetEntity extends Entity {

    private volatile Point2D.Double position = new Point2D.Double(200, 200);

    public Point2D.Double getPosition() {
        return position;
    }

    public void setPosition(Point2D.Double position) {
        this.position = position;
    }

    public double x() {
        return position.x;
    }

    public double y() {
        return position.y;
    }

    @Override
    public void update(int period) {

    }
}
