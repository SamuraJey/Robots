package model;

import model.entities.Entity;
import model.entities.GridEntity;

import java.util.List;

public interface ModelDataProvider {
    List<Entity> getEntities();

    GridEntity getGrid();
}
