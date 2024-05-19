package view.renderers;

import model.entities.Bacteria;
import model.entities.Entity;
import view.GraphicsUtils;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class BacteriaRenderer extends AbstractRenderer {
    @Override
    public void render(Graphics2D g, Entity entity) {
        Bacteria bacteria = (Bacteria) entity;
        int bacteriaX = GraphicsUtils.round(bacteria.getBacteriaPosition().x);
        int bacteriaY = GraphicsUtils.round(bacteria.getBacteriaPosition().y);
        int bacteriaWeight = bacteria.getBacteriaWeight();
        int bacteriaHeight = bacteria.getBacteriaHeight();
        //AffineTransform t = AffineTransform.getRotateInstance(bacteria.getBacteriaDirection(), robotCenterX, robotCenterY);
        //g.setTransform(t);
        g.setColor(Color.BLUE);
        GraphicsUtils.fillRect(g, bacteriaX, bacteriaY, bacteriaHeight, bacteriaWeight);


    }
}