package ViewModel;

import Model.TargetModel;

import java.awt.geom.Point2D;

public class DefaultRobotViewModel implements RobotViewModel {

    private final TargetModel m_targetModel;

    public DefaultRobotViewModel(TargetModel tm) {
        m_targetModel = tm;
    }

    @Override
    public void setTargetPosition(Point2D.Double targetPosition) {
        m_targetModel.setPosition(targetPosition);
    }
}
