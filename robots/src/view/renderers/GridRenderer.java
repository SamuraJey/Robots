package view.renderers;

import model.entities.Entity;
import model.entities.Grid;

import java.awt.*;

public class GridRenderer extends AbstractRenderer{
    @Override
    public void render(Graphics2D g, Entity entity) {
        g.setColor(Color.GRAY);
        Grid grid = (Grid) entity;
        int cellWidth = grid.getCellWidth();
        int cellHeigth = grid.getCellHeight();
        int heightOfScreen = grid.getHeightOfScreen();
        int widthOfScreen = grid.getWidthOfScreen();

        for (int i = 0; i <= grid.getCountWidth(); i++) { // вертикальные линии
            g.drawLine(0,cellWidth*i,heightOfScreen,cellWidth*i);
        }
        for (int i = 0; i <= grid.getCountHeight(); i++) { // горизонтальные линии
            g.drawLine(cellHeigth*i, 0,cellHeigth*i,widthOfScreen);
        }
    }

}
