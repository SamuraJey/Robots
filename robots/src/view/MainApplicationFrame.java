package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import log.LogWindow;
import log.Logger;
import viewmodel.ViewModel;

public class MainApplicationFrame extends JFrame implements PauseStateListener{
    private final JDesktopPane desktopPane = new JDesktopPane();
    

    public final static int WIDTH = 600;
    public final static int HEIGHT = 600;
    private ViewModel viewModel;
    private JMenuItem pauseMenuItem;

    public MainApplicationFrame(GameVisualizer gameVisualizer, ViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewModel.addPauseStateListener(this);
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height - inset * 2);

        setContentPane(desktopPane);
        pauseMenuItem = createPauseMenuItem();

        LogWindow logWindow = createLogWindow();
        addWindow(logWindow);

        GameWindow gameWindow = new GameWindow(gameVisualizer);
        gameWindow.setSize(WIDTH + 20, HEIGHT + 40);
        addWindow(gameWindow);

        setJMenuBar(createMenuBar());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    protected LogWindow createLogWindow() {
        LogWindow logWindow = new LogWindow(Logger.getDefaultLogSource());
        logWindow.setLocation(10, 10);
        logWindow.setSize(300, 800);
        setMinimumSize(logWindow.getSize());
        logWindow.pack();
        Logger.debug("Протокол работает");
        return logWindow;
    }

    protected void addWindow(JInternalFrame frame) {
        desktopPane.add(frame);
        frame.setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createLookAndFeelMenu());
        menuBar.add(createTestMenu());
        menuBar.add(pauseMenuItem);
        return menuBar;
    }

    private JMenu createLookAndFeelMenu() {
        JMenu lookAndFeelMenu = new JMenu("Режим отображения");
        lookAndFeelMenu.setMnemonic(KeyEvent.VK_V);
        lookAndFeelMenu.getAccessibleContext().setAccessibleDescription("Управление режимом отображения приложения");

        lookAndFeelMenu.add(
                createLookAndFeelMenuItem("Системная схема", KeyEvent.VK_S, UIManager.getSystemLookAndFeelClassName()));
        lookAndFeelMenu.add(createLookAndFeelMenuItem("Универсальная схема", KeyEvent.VK_U,
                UIManager.getCrossPlatformLookAndFeelClassName()));

        return lookAndFeelMenu;
    }

    private JMenuItem createLookAndFeelMenuItem(String text, int mnemonic, String className) {
        JMenuItem menuItem = new JMenuItem(text, mnemonic);
        menuItem.addActionListener((event) -> {
            setLookAndFeel(className);
            this.invalidate();
        });
        return menuItem;
    }

    private JMenu createTestMenu() {
        JMenu testMenu = new JMenu("Тесты");
        testMenu.setMnemonic(KeyEvent.VK_T);
        testMenu.getAccessibleContext().setAccessibleDescription("Тестовые команды");

        testMenu.add(createTestMenuItem("Сообщение в лог", KeyEvent.VK_S, () -> Logger.debug("Новая строка")));

        return testMenu;
    }

    private JMenuItem createTestMenuItem(String text, int mnemonic, Runnable action) {
        JMenuItem menuItem = new JMenuItem(text, mnemonic);
        menuItem.addActionListener((event) -> action.run());
        return menuItem;
    }

    private void setLookAndFeel(String className) {
        try {
            UIManager.setLookAndFeel(className);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            // just ignore
        }
    }

    private JMenuItem createPauseMenuItem() {
        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        pauseMenuItem.addActionListener((event) -> {
            boolean isPaused = !viewModel.getIsPaused(); // Get the current paused state and invert it
            viewModel.setPaused(isPaused); // Set the new paused state
            Logger.debug(isPaused ? "Пауза" : "Продолжить"); // Log the new state
        });
        return pauseMenuItem;
    }

    @Override
    public void onPauseStateChanged(boolean isPaused) {
        SwingUtilities.invokeLater(() -> {
            pauseMenuItem.setText(isPaused ? "Resume" : "Pause");
        });
    }

    
}