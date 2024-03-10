package log;

import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;

public class LogWindowSource {
    private int m_iQueueLength;

    private Deque<LogEntry> m_messages;
    private final ArrayList<WeakReference<LogChangeListener>> m_listeners;

    public LogWindowSource(int iQueueLength) {
        m_iQueueLength = iQueueLength;
        m_messages = new ArrayDeque<LogEntry>(iQueueLength);
        m_listeners = new ArrayList<WeakReference<LogChangeListener>>();
    }

    public void registerListener(LogChangeListener listener) {
        synchronized (m_listeners) {
            m_listeners.add(new WeakReference<LogChangeListener>(listener));
        }
    }

    public void unregisterListener(LogChangeListener listener) {
        synchronized (m_listeners) {
            Iterator<WeakReference<LogChangeListener>> iterator = m_listeners.iterator();
            while (iterator.hasNext()) {
                WeakReference<LogChangeListener> weakRef = iterator.next();
                if (weakRef.get() == listener) {
                    iterator.remove();
                }
            }
        }
    }

    public void append(LogLevel logLevel, String strMessage) {
        while (m_messages.size() >= m_iQueueLength) {
            m_messages.removeFirst();
        }
        LogEntry entry = new LogEntry(logLevel, strMessage);
        m_messages.add(entry);
        notifyListeners();
    }

    private void notifyListeners() {
        synchronized (m_listeners) {
            Iterator<WeakReference<LogChangeListener>> iterator = m_listeners.iterator();
            while (iterator.hasNext()) {
                WeakReference<LogChangeListener> weakRef = iterator.next();
                LogChangeListener listener = weakRef.get();
                if (listener != null) {
                    listener.onLogChanged();
                } else {
                    iterator.remove();
                }
            }
        }
    }

    public int size() {
        return m_messages.size();
    }

    public Iterable<LogEntry> range(int startFrom, int count) {
        if (startFrom < 0 || startFrom >= m_messages.size()) {
            return Collections.emptyList();
        }
        int indexTo = Math.min(startFrom + count, m_messages.size());
        return new ArrayList<LogEntry>(m_messages).subList(startFrom, indexTo);
    }

    public Iterable<LogEntry> all() {
        return m_messages;
    }
}