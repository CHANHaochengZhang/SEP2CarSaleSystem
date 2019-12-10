package model;

import java.beans.PropertyChangeListener;

public interface PropertyChangeObserver {

    void addPropertyChangeListener(String eventName, PropertyChangeListener listener);
}
