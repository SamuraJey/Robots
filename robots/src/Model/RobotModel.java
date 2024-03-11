package Model;

import java.awt.geom.Point2D;
import java.util.Timer;
import java.util.TimerTask;

public class RobotModel {

    private final Timer m_timer = initTimer();

    private static Timer initTimer()
    {
        Timer timer = new Timer("events generator", true);
        return timer;
    }

    public RobotModel(){
        m_timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                onModelUpdateEvent();
            }
        }, 0, 10);
    }
    private volatile Point2D.Double m_robotPosition = new Point2D.Double(100, 100);

    public Point2D.Double getRobotPosition() {
        return m_robotPosition;
    }

    private volatile double m_robotDirection = 0;

    public double getRobotDirection() {
        return m_robotDirection;
    }

    private volatile Point2D.Double m_targetPosition = new Point2D.Double(200, 100);

    public Point2D.Double getTargetPosition() {
        return m_targetPosition;
    }

    public void setTargetPosition(Point2D.Double position){
        m_targetPosition = position;
    }

    private static final double maxVelocity = 0.1;
    private static final double maxAngularVelocity = 0.001;
    protected void onModelUpdateEvent()
    {
        double distance = distance(m_targetPosition.x, m_targetPosition.y,
                m_robotPosition.x, m_robotPosition.y);
        if (distance < 0.5)
        {
            return;
        }
        double velocity = maxVelocity;
        double angleToTarget = angleTo(m_robotPosition.x, m_robotPosition.y, m_targetPosition.x, m_targetPosition.y);
        double angularVelocity = 0;
        if (angleToTarget > m_robotDirection)
        {
            angularVelocity = maxAngularVelocity;
        }
        if (angleToTarget < m_robotDirection)
        {
            angularVelocity = -maxAngularVelocity;
        }

        moveRobot(velocity, angularVelocity, 10);
    }
    private static double distance(double x1, double y1, double x2, double y2)
    {
        double diffX = x1 - x2;
        double diffY = y1 - y2;
        return Math.sqrt(diffX * diffX + diffY * diffY);
    }

    private static double angleTo(double fromX, double fromY, double toX, double toY)
    {
        double diffX = toX - fromX;
        double diffY = toY - fromY;

        return asNormalizedRadians(Math.atan2(diffY, diffX));
    }

    private static double applyLimits(double value, double min, double max)
    {
        if (value < min)
            return min;
        if (value > max)
            return max;
        return value;
    }

    private void moveRobot(double velocity, double angularVelocity, double duration)
    {
        velocity = applyLimits(velocity, 0, maxVelocity);
        angularVelocity = applyLimits(angularVelocity, -maxAngularVelocity, maxAngularVelocity);
        double newX = m_robotPosition.x + velocity / angularVelocity *
                (Math.sin(m_robotDirection  + angularVelocity * duration) -
                        Math.sin(m_robotDirection));
        if (!Double.isFinite(newX))
        {
            newX = m_robotPosition.x + velocity * duration * Math.cos(m_robotDirection);
        }
        double newY = m_robotPosition.y - velocity / angularVelocity *
                (Math.cos(m_robotDirection  + angularVelocity * duration) -
                        Math.cos(m_robotDirection));
        if (!Double.isFinite(newY))
        {
            newY = m_robotPosition.y + velocity * duration * Math.sin(m_robotDirection);
        }
        m_robotPosition.x = newX;
        m_robotPosition.y = newY;
        double newDirection = asNormalizedRadians(m_robotDirection + angularVelocity * duration);
        m_robotDirection = newDirection;
    }

    private static double asNormalizedRadians(double angle)
    {
        while (angle < 0)
        {
            angle += 2*Math.PI;
        }
        while (angle >= 2*Math.PI)
        {
            angle -= 2*Math.PI;
        }
        return angle;
    }

}
