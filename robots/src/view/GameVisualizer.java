package view;

import model.entities.*;
import view.renderers.*;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GameVisualizer extends JPanel {

    private final Map<Class<? extends Entity>, AbstractRenderer> rendererMap = Map.of(
            Bacteria.class, new BacteriaRenderer(),
            Grid.class, new GridRenderer(),
            Food.class, new FoodRenderer()
    );
    public List<Entity> entitiesToRender = Collections.emptyList();

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
