package model.entities;

public final class GridEntity extends Entity {
    private final int cellCountWidth;
    private final int cellCountHeight;
    private final int widthOfScreen;
    private final int heightOfScreen;
    private final int cellWidth;
    private final int cellHeight;

    public GridEntity(int cellCountWidth, int cellCountHeight, int widthOfScreen, int heightOfScreen) {
        this.cellCountWidth = cellCountWidth;
        this.cellCountHeight = cellCountHeight;
        this.widthOfScreen = widthOfScreen;
        this.heightOfScreen = heightOfScreen;
        cellWidth = widthOfScreen / cellCountWidth;
        cellHeight = heightOfScreen / cellCountHeight;
    }

    public int getCountWidth(){ return cellCountWidth; }

    public int  getCountHeight(){ return cellCountHeight; }
    public int getWidthOfScreen(){ return widthOfScreen; }
    public int getHeightOfScreen(){ return heightOfScreen; }
    public int getCellWidth(){ return cellWidth; }
    public int getCellHeight(){ return cellHeight; }

    @Override
    public void update(int period) {

    }
}