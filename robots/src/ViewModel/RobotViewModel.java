package ViewModel;

import java.awt.geom.Point2D;

public interface RobotViewModel {
    Point2D.Double getRobotPosition();
    double getRobotDirection();
    Point2D.Double getTargetPosition();

    void setTargetPosition(Point2D.Double targetPosition);
}
