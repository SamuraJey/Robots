package view.renderers;

import model.entities.Entity;
import model.entities.RobotEntity;
import view.GraphicsUtils;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class RobotRenderer extends AbstractRenderer {

    @Override
    public void render(Graphics2D g, Entity entity) {
        RobotEntity robot = (RobotEntity) entity;
        int robotCenterX = GraphicsUtils.round(robot.getRobotPosition().x);
        int robotCenterY = GraphicsUtils.round(robot.getRobotPosition().y);
        //AffineTransform t = AffineTransform.getRotateInstance(robot.getRobotDirection(), robotCenterX, robotCenterY);
        //g.setTransform(t);
        g.setColor(Color.MAGENTA);
        GraphicsUtils.fillOval(g, robotCenterX, robotCenterY, 30, 10);
        g.setColor(Color.BLACK);
        GraphicsUtils.drawOval(g, robotCenterX, robotCenterY, 30, 10);
        g.setColor(Color.WHITE);
        GraphicsUtils.fillOval(g, robotCenterX + 10, robotCenterY, 5, 5);
        g.setColor(Color.BLACK);
        GraphicsUtils.drawOval(g, robotCenterX + 10, robotCenterY, 5, 5);
    }
}