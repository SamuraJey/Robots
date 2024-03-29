package viewmodel;

import model.Model;
import model.entities.TargetEntity;
import view.GameVisualizer;

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
        TargetEntity targetEntity = (TargetEntity) model.entitiesRegistry.getEntity(TargetEntity.class);
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


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                targetEntity.setPosition(
                        new Point2D.Double(e.getPoint().x, e.getPoint().y)
                );
            }
        });
    }
}
