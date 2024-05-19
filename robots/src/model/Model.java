package model;

import model.entities.*;

public class Model {
    public final DefaultEntitiesRegistry entitiesRegistry;
    private final int widthOfScreen;
    private final int heightOfScreen;
    private final int cellCountWidth;
    private final int cellCountHeight;


    public Model(){
        entitiesRegistry = new DefaultEntitiesRegistry();
        widthOfScreen = 400;
        heightOfScreen = 400;
        cellCountWidth = 10;
        cellCountHeight = 10;
        init();
    }
    private void init(){
        GridEntity grid = new GridEntity(cellCountWidth, cellCountHeight, widthOfScreen, heightOfScreen);
        FoodEntity food = new FoodEntity(grid.getCellWidth(),grid.getCellHeight(),cellCountWidth,cellCountHeight);
        BacteriaEntity bacteria = new BacteriaEntity(entitiesRegistry,food,grid.getCellWidth(),grid.getCellHeight(),cellCountWidth,cellCountHeight);
        entitiesRegistry.register(bacteria);
        entitiesRegistry.register(grid);
        entitiesRegistry.register(food);
    }

    public void update(int period){
        for (Entity entity : entitiesRegistry.getEntities()){
            entity.update(period);
        }
        entitiesRegistry.delete();
    }
}