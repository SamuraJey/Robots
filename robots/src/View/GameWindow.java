package View;

import Model.RobotModel;
import ViewModel.DefaultRobotViewModel;
import ViewModel.RobotViewModel;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JInternalFrame
{
    private final GameVisualizer m_visualizer;
    private final RobotViewModel m_robotViewModel;
    private final RobotModel m_robotModel;
    public GameWindow() 
    {
        super("Игровое поле", true, true, true, true);
        m_robotModel = new RobotModel();
        m_robotViewModel = new DefaultRobotViewModel(m_robotModel);
        m_visualizer = new GameVisualizer(m_robotViewModel);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_visualizer, BorderLayout.CENTER);
        getContentPane().add(panel);
        pack();
    }
}
