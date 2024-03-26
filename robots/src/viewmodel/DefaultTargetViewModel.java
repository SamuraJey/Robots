package viewmodel;

import model.TargetModel;

import java.awt.geom.Point2D;

public class DefaultTargetViewModel implements TargetViewModel {

    private final TargetModel m_targetModel;

    public DefaultTargetViewModel(TargetModel tm) {
        m_targetModel = tm;
    }

    @Override
    public void setTargetPosition(Point2D.Double targetPosition) {
        m_targetModel.setPosition(targetPosition);
    }
}
