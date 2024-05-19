package view;

import model.entities.*;
import view.renderers.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GameVisualizer extends JPanel {

    private List<Entity> entitiesToRender;
    private final Map<Class<? extends Entity>, AbstractRenderer> rendererMap = Map.of(
            BacteriaEntity.class, new BacteriaRenderer(),
            GridEntity.class, new GridRenderer(),
            FoodEntity.class, new FoodRenderer()
    );

    public  void setEntitiesToRender(List<Entity> entitiesToRender){
        this.entitiesToRender = entitiesToRender;
    }
    public GameVisualizer() {
        setDoubleBuffered(true);
    }

    public void onRedrawEvent() {
        EventQueue.invokeLater(this::repaint);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Entity entity : entitiesToRender) {
            rendererMap.get(entity.getClass()).render((Graphics2D) g, entity);
        }
    }
}
