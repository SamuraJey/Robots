package ViewModel;

import Model.RobotModel;

import java.awt.geom.Point2D;

public class DefaultRobotViewModel implements RobotViewModel{

    private final RobotModel m_robotModel;
    public DefaultRobotViewModel(RobotModel rm){
        m_robotModel = rm;
    }
    @Override
    public Point2D.Double getRobotPosition() {
        return m_robotModel.getRobotPosition();
    }

    @Override
    public double getRobotDirection() {
        return m_robotModel.getRobotDirection();
    }

    @Override
    public Point2D.Double getTargetPosition() {
        return m_robotModel.getTargetPosition();
    }

    @Override
    public void setTargetPosition(Point2D.Double targetPosition) {
        m_robotModel.setTargetPosition(targetPosition);
    }
}
