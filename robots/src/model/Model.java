package model;

import model.entities.*;

import java.util.List;

public class Model implements ModelDataProvider {
    public final DefaultEntitiesRegistry entitiesRegistry;
    private final int widthOfScreen;
    private final int heightOfScreen;
    private final int cellCountWidth;
    private final int cellCountHeight;
    private final int cellWidth;
    private final int cellHeight;
    private final WorldContext worldContext;


    public Model(int widthOfScreen,int heightOfScreen){
        entitiesRegistry = new DefaultEntitiesRegistry();
        this.widthOfScreen = widthOfScreen;
        this.heightOfScreen = heightOfScreen;
        cellCountWidth = 10;
        cellCountHeight = 10;
        cellWidth = widthOfScreen / cellCountWidth;
        cellHeight = heightOfScreen / cellCountHeight;
        worldContext = new WorldContext(this);
        init();
    }
    private void init(){
        GridEntity grid = new GridEntity(cellCountWidth, cellCountHeight, widthOfScreen, heightOfScreen, cellWidth, cellHeight);
        FoodEntity food1 = new FoodEntity(cellWidth,cellHeight,cellCountWidth,cellCountHeight);
        FoodEntity food2 = new FoodEntity(cellWidth, cellHeight, cellCountWidth, cellCountHeight);
        BacteriaEntity bacteria1 = new BacteriaEntity(cellWidth,cellHeight);
        BacteriaEntity bacteria2 = new BacteriaEntity(cellWidth,cellHeight);
        BacteriaEntity bacteria3 = new BacteriaEntity(cellWidth,cellHeight);
        entitiesRegistry.register(bacteria1);
        entitiesRegistry.register(bacteria2);
        entitiesRegistry.register(bacteria3);
        entitiesRegistry.register(grid);
        entitiesRegistry.register(food1);
        entitiesRegistry.register(food2);
    }

    public int getCellHeight(){ return cellHeight;}

    public int getCellWidth(){ return cellWidth;}
    public int getCellCountWidth(){ return cellCountWidth;}
    public int getCellCountHeight(){ return cellCountHeight;}

    public void update(int period){
        for (Entity entity : entitiesRegistry.getEntities()){
            entity.update(worldContext);
        }
        entitiesRegistry.delete();
    }

    @Override
    public List<Entity> getEntities() {
        return entitiesRegistry.getEntities();
    }
}