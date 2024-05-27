package viewmodel;

import model.Model;
import view.GameVisualizer;
import view.PauseStateListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ViewModel {
    private final Timer timer = new Timer("events generator", true);
    private final int redrawPeriod = 150;
    private final int modelUpdatePeriod = 150;
    private boolean isPaused = false; // Add this line
    private final List<PauseStateListener> pauseStateListeners = new ArrayList<>();

    public void addPauseStateListener(PauseStateListener listener) {
        pauseStateListeners.add(listener);
    }

    public void removePauseStateListener(PauseStateListener listener) {
        pauseStateListeners.remove(listener);
    }

    public void setPaused(boolean isPaused) {
        this.isPaused = isPaused;
        for (PauseStateListener listener : pauseStateListeners) {
            listener.onPauseStateChanged(isPaused);
        }
    }

    public ViewModel(Model model, GameVisualizer gameVisualizer) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!isPaused) { // Add this line
                    gameVisualizer.setModelDataProvider(model);
                    gameVisualizer.onRedrawEvent();
                }
            }
        }, 0, redrawPeriod);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!isPaused) { // Add this line
                    model.update(modelUpdatePeriod);
                }
            }
        }, 0, modelUpdatePeriod);
    }



    public boolean getIsPaused() {
        return this.isPaused;
    }
}
