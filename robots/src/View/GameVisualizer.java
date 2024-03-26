package View;

import Model.Entity;
import Model.RobotModel;
import Model.TargetModel;
import View.renderers.AbstractRenderer;
import View.renderers.RobotRenderer;
import View.renderers.TargetRenderer;
import ViewModel.EntitiesGetter;
import ViewModel.RobotViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class GameVisualizer extends JPanel {
    private final Timer m_timer = initTimer();
    private final EntitiesGetter m_entitiesGetter;
    private final RobotViewModel m_robotViewModel;
    private final int m_period = 10;
    private final Map<Class<? extends Entity>, AbstractRenderer> rendererMap = Map.of(
            RobotModel.class, new RobotRenderer(),
            TargetModel.class, new TargetRenderer()
    );

    private static Timer initTimer() {
        Timer timer = new Timer("events generator", true);
        return timer;
    }

    public GameVisualizer(EntitiesGetter entitiesGetter, RobotViewModel robotViewModel) {
        m_robotViewModel = robotViewModel;
        m_entitiesGetter = entitiesGetter;
        m_timer.schedule(new TimerTask() {
            @Override
            public void run() {
                onRedrawEvent();
            }
        }, 0, m_period);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setTargetPosition(e.getPoint());
                repaint();
            }
        });
        setDoubleBuffered(true);
    }

    protected void onRedrawEvent() {
        EventQueue.invokeLater(this::repaint);
    }

    protected void setTargetPosition(Point p) {
        m_robotViewModel.setTargetPosition(new Point2D.Double(p.x, p.y));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Entity entity : m_entitiesGetter.getEntities()) {
            rendererMap.get(entity.getClass()).render((Graphics2D) g, entity);
            entity.update(m_period);
        }
    }
}
