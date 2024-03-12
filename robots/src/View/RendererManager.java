package View;

import Model.Entity;
import ViewModel.EntitiesGetter;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RendererManager extends JPanel {
    private Map<Class<?>, Renderer<Entity>> renderersInstances = new HashMap<>();
    private final EntitiesGetter entitiesGetter;

    public RendererManager(EntitiesGetter entitiesGetter) {
        this.entitiesGetter = entitiesGetter;
    }

    public void linkEntities(List<Entity> entities) {
        renderers.clear();
        for (Entity entity : entities) {
            renderers.put(entity, renderersInstances.get(entity.getClass()));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Entity entity : entitiesGetter.getEntities()) {
            renderersInstances.get(entity.getClass()).render(entity, g);
        }
    }
}
