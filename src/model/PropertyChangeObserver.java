package model;

import java.beans.PropertyChangeListener;

public interface PropertyChangeObserver {
// observe new messages
    void addPropertyChangeListener(String eventName, PropertyChangeListener listener);
     void addPropertyChangeListener(PropertyChangeListener listener);
     void removePropertyChangeListener(String name, PropertyChangeListener listener);
     void removePropertyChangeListener(PropertyChangeListener listener);
}
