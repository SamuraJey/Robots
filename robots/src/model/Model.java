package model;

import model.entities.Entity;
import model.entities.RobotEntity;
import model.entities.TargetEntity;

public class Model {
    public final EntitiesRegistry entitiesRegistry;
    public Model(){
        entitiesRegistry = new DefaultEntitiesRegistry();
        init();
    }

    private void init(){
        TargetEntity targetEntity = new TargetEntity();
        RobotEntity robotEntity = new RobotEntity(targetEntity);
        entitiesRegistry.register(targetEntity);
        entitiesRegistry.register(robotEntity);
    }

    public void update(int period){
        for (Entity entity : entitiesRegistry.getEntities()){
            entity.update(period);
        }
    }
}
