import model.Model;
import view.GameVisualizer;
import view.MainApplicationFrame;
import viewmodel.ViewModel;

import java.awt.Frame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main
{
    public static void main(String[] args) {
      try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception e) {
        e.printStackTrace();
      }
      SwingUtilities.invokeLater(() -> {
        
        GameVisualizer gameVisualizer = new GameVisualizer();
        MainApplicationFrame frame = new MainApplicationFrame(gameVisualizer);
        Model model = new Model(MainApplicationFrame.WIDTH, MainApplicationFrame.HEIGHT);
        @SuppressWarnings("unused")
        ViewModel viewModel = new ViewModel(model, gameVisualizer);

        
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
      });
    }}


