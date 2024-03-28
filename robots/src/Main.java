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
        Model model = new Model();
        ViewModel viewModel = new ViewModel(model, gameVisualizer);

        MainApplicationFrame frame = new MainApplicationFrame(gameVisualizer);
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
      });
    }}
