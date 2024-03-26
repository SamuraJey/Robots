package view;

import model.RobotModel;
import model.TargetModel;
import viewmodel.DefaultEntitiesGetter;
import viewmodel.DefaultTargetViewModel;
import viewmodel.TargetViewModel;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JInternalFrame {
    private final GameVisualizer m_visualizer;

    public GameWindow() {
        super("Игровое поле", true, true, true, true);

        TargetModel tm = new TargetModel();
        RobotModel rm = new RobotModel(tm);
        TargetViewModel targetViewModel = new DefaultTargetViewModel(tm);
        DefaultEntitiesGetter entitiesGetter = new DefaultEntitiesGetter();
        entitiesGetter.register(tm);
        entitiesGetter.register(rm);

        m_visualizer = new GameVisualizer(entitiesGetter, targetViewModel);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_visualizer, BorderLayout.CENTER);
        getContentPane().add(panel);
        pack();
    }
}
