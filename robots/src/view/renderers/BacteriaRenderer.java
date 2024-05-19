package view.renderers;

import model.entities.BacteriaEntity;
import model.entities.Entity;
import view.GraphicsUtils;

import java.awt.*;

public class BacteriaRenderer extends AbstractRenderer {
    @Override
    public void render(Graphics2D g, Entity entity) {
        BacteriaEntity bacteria = (BacteriaEntity) entity;
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