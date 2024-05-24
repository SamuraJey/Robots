package view.renderers;

import model.entities.Entity;
import model.entities.GridEntity;

import java.awt.*;

public class GridRenderer extends AbstractRenderer{
    @Override
    public void render(Graphics2D g, Entity entity) {
        g.setColor(Color.GRAY);
        GridEntity grid = (GridEntity) entity;
        int cellWidth = grid.getCellWidth();
        int cellHeight = grid.getCellHeight();
        int heightOfScreen = grid.getHeightOfScreen();
        int widthOfScreen = grid.getWidthOfScreen();

        for (int i = 0; i <= grid.getCountWidth(); i++) {
            g.drawLine(0,cellWidth*i,heightOfScreen,cellWidth*i);
        }
        for (int i = 0; i <= grid.getCountHeight(); i++) {
            g.drawLine(cellHeight*i, 0,cellHeight*i,widthOfScreen);
        }
    }

}
