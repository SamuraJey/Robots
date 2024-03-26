package View.renderers;

import Model.Entity;
import Model.TargetModel;
import View.GraphicsUtils;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class TargetRenderer extends AbstractRenderer {
    @Override
    public void render(Graphics2D g, Entity entity) {
        TargetModel target = (TargetModel) entity;
        AffineTransform t = AffineTransform.getRotateInstance(0, 0, 0);
        g.setTransform(t);
        g.setColor(Color.GREEN);
        GraphicsUtils.fillOval(g, (int) target.x(), (int) target.y(), 5, 5);
        g.setColor(Color.BLACK);
        GraphicsUtils.drawOval(g, (int) target.x(), (int) target.y(), 5, 5);
    }
}
