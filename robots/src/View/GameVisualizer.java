package View;

import ViewModel.RobotViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.Timer;
import java.util.TimerTask;

public class GameVisualizer extends JPanel
{
    private final Timer m_timer = initTimer();
    private final RobotViewModel m_robotViewModel;
    
    private static Timer initTimer() 
    {
        Timer timer = new Timer("events generator", true);
        return timer;
    }

    public GameVisualizer(RobotViewModel rvm)
    {
        m_robotViewModel = rvm;
        m_timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                onRedrawEvent();
            }
        }, 0, 50);
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                setTargetPosition(e.getPoint());
                repaint();
            }
        });
        setDoubleBuffered(true);
    }

    private Point m_targetPosition;
    private Point m_robotPosition;
    private double m_robotDirection;

    protected void onRedrawEvent()
    {
        Point2D rPos = m_robotViewModel.getRobotPosition();
        Point2D tPos = m_robotViewModel.getTargetPosition();
        m_robotPosition = new Point((int)rPos.getX(), (int)rPos.getY());
        m_targetPosition = new Point((int)tPos.getX(), (int)tPos.getY());
        m_robotDirection = m_robotViewModel.getRobotDirection();

        EventQueue.invokeLater(this::repaint);
    }

    protected void setTargetPosition(Point p)
    {
        m_robotViewModel.setTargetPosition(new Point2D.Double(p.x,p.y));
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g; 
        drawRobot(g2d, round(m_robotPosition.x), round(m_robotPosition.y), m_robotDirection);
        drawTarget(g2d, m_targetPosition.x, m_targetPosition.y);
    }
    
    private static void fillOval(Graphics g, int centerX, int centerY, int diam1, int diam2)
    {
        g.fillOval(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
    }
    
    private static void drawOval(Graphics g, int centerX, int centerY, int diam1, int diam2)
    {
        g.drawOval(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
    }
    
    private void drawRobot(Graphics2D g, int x, int y, double direction)
    {
        int robotCenterX = round(m_robotPosition.x);
        int robotCenterY = round(m_robotPosition.y);
        AffineTransform t = AffineTransform.getRotateInstance(direction, robotCenterX, robotCenterY); 
        g.setTransform(t);
        g.setColor(Color.MAGENTA);
        fillOval(g, robotCenterX, robotCenterY, 30, 10);
        g.setColor(Color.BLACK);
        drawOval(g, robotCenterX, robotCenterY, 30, 10);
        g.setColor(Color.WHITE);
        fillOval(g, robotCenterX  + 10, robotCenterY, 5, 5);
        g.setColor(Color.BLACK);
        drawOval(g, robotCenterX  + 10, robotCenterY, 5, 5);
    }
    
    private void drawTarget(Graphics2D g, int x, int y)
    {
        AffineTransform t = AffineTransform.getRotateInstance(0, 0, 0); 
        g.setTransform(t);
        g.setColor(Color.GREEN);
        fillOval(g, x, y, 5, 5);
        g.setColor(Color.BLACK);
        drawOval(g, x, y, 5, 5);
    }
    private static int round(double value)
    {
        return (int)(value + 0.5);
    }
}
