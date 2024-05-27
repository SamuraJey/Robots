package model.entities;

import model.WorldContext;

public final class GridEntity extends Entity  {
    private final int cellCountWidth;
    private final int cellCountHeight;
    private final int widthOfScreen;
    private final int heightOfScreen;
    private final int cellWidth;
    private final int cellHeight;

    public GridEntity(int cellCountWidth, int cellCountHeight, int widthOfScreen, int heightOfScreen, int cellWidth, int cellHeight) {
        this.cellCountWidth = cellCountWidth;
        this.cellCountHeight = cellCountHeight;
        this.widthOfScreen = widthOfScreen;
        this.heightOfScreen = heightOfScreen;
        this.cellHeight = cellHeight;
        this.cellWidth = cellWidth;
    }

    public int getCountWidth(){ return cellCountWidth; }

    public int  getCountHeight(){ return cellCountHeight; }
    public int getWidthOfScreen(){ return widthOfScreen; }
    public int getHeightOfScreen(){ return heightOfScreen; }
    public int getCellWidth(){ return cellWidth; }
    public int getCellHeight(){ return cellHeight; }

    @Override
    public void update(WorldContext worldContext) {

    }

}