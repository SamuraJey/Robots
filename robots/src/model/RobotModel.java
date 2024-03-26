package model;

import java.awt.geom.Point2D;

public class RobotModel extends Entity {

    private final TargetModel m_target;

    public RobotModel(TargetModel target) {
        m_target = target;
    }

    private volatile Point2D.Double m_robotPosition = new Point2D.Double(100, 100);

    public Point2D.Double getRobotPosition() {
        return m_robotPosition;
    }

    private volatile double m_robotDirection = 0;

    public double getRobotDirection() {
        return m_robotDirection;
    }

    private static final double maxVelocity = 0.1;
    private static final double maxAngularVelocity = 0.001;

    public void update(int period) {
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
    }

}
