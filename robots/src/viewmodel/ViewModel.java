package viewmodel;

import model.Model;
import view.GameVisualizer;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Timer;
import java.util.TimerTask;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class ViewModel {
    private final Timer timer = new Timer("events generator", true);

    private final int redrawPeriod = 50;
    private final int modelUpdatePeriod = 10;

    public ViewModel(Model model, GameVisualizer gameVisualizer) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                gameVisualizer.entitiesToRender = model.entitiesRegistry.getEntities();
                gameVisualizer.onRedrawEvent();
            }
        }, 0, redrawPeriod);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                model.update(modelUpdatePeriod);
            }
        }, 0, modelUpdatePeriod);
    }
}
