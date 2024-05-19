package model;

import model.entities.*;

public class Model {
    public final EntitiesRegistry entitiesRegistry;
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
        TargetEntity targetEntity = new TargetEntity();
        RobotEntity robotEntity = new RobotEntity(targetEntity);
        Grid grid = new Grid(cellCountWidth, cellCountHeight, widthOfScreen, heightOfScreen);
        Food food = new Food(grid.getCellWidth(),grid.getCellHeight(),cellCountWidth,cellCountHeight);
        Bacteria bacteria = new Bacteria(food,grid.getCellWidth(),grid.getCellHeight(),cellCountWidth,cellCountHeight);
        entitiesRegistry.register(targetEntity);
        entitiesRegistry.register(robotEntity);
        entitiesRegistry.register(bacteria);
        entitiesRegistry.register(grid);
        entitiesRegistry.register(food);
    }

    public void update(int period){
        for (Entity entity : entitiesRegistry.getEntities()){
            entity.update(period);
        }
    }
}