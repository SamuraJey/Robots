package model;

import model.entities.*;

import java.awt.geom.Point2D;
import java.util.List;

public class Model implements ModelDataProvider {
    public final DefaultEntitiesRegistry entitiesRegistry;
    private final int cellCountWidth;
    private final int cellCountHeight;
    private final int cellWidth;
    private final int cellHeight;
    private final WorldContext worldContext;
    private final GridEntity grid;

    public Model(int widthOfScreen, int heightOfScreen) {
        entitiesRegistry = new DefaultEntitiesRegistry();
        cellCountWidth = 10;
        cellCountHeight = 10;
        cellWidth = widthOfScreen / cellCountWidth;
        cellHeight = heightOfScreen / cellCountHeight;
        worldContext = new WorldContext(this);
        this.grid = new GridEntity(cellCountWidth, cellCountHeight, widthOfScreen, heightOfScreen, cellWidth,
                cellHeight);
        init();
    }

    private void init() {
        for (int i = 0; i < 5; i++) {
            FoodEntity food = new FoodEntity(cellWidth, cellHeight,
                    new Point2D.Double(MathUtils.getRandomNumber(cellCountWidth) * cellWidth,
                            MathUtils.getRandomNumber(cellCountHeight) * cellHeight));
            entitiesRegistry.register(food);
        }

        for (int i = 0; i < 3; i++) {
            BacteriaEntity bacteria = new BacteriaEntity(cellWidth, cellHeight,
                    new Point2D.Double(MathUtils.getRandomNumber(cellCountWidth) * cellWidth,
                            MathUtils.getRandomNumber(cellCountHeight) * cellHeight));
            entitiesRegistry.register(bacteria);
        }

        for (int i = 0; i < 3; i++) {
            PoisonEntity poison = new PoisonEntity(cellWidth, cellHeight,
                    new Point2D.Double(MathUtils.getRandomNumber(cellCountWidth) * cellWidth,
                            MathUtils.getRandomNumber(cellCountHeight) * cellHeight));
            entitiesRegistry.register(poison);
        }
        // entitiesRegistry.register(grid);
        // entitiesRegistry.register(food1);
        // entitiesRegistry.register(food2);
    }

    public int getCellHeight() {
        return cellHeight;
    }

    public int getCellWidth() {
        return cellWidth;
    }

    public int getCellCountWidth() {
        return cellCountWidth;
    }

    public int getCellCountHeight() {
        return cellCountHeight;
    }

    public void update(int period) {
        for (Entity entity : entitiesRegistry.getEntities()) {
            entity.update(worldContext);
        }
        entitiesRegistry.delete();
    }

    @Override
    public List<Entity> getEntities() {
        return entitiesRegistry.getEntities();
    }

    @Override
    public GridEntity getGrid() {
        return grid;// entitiesRegistry.getGrid();
    }
}