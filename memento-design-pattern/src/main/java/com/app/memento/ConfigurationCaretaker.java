package com.app.memento;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationCaretaker {
    private List<ConfigurationMemento> mementoList = new ArrayList<>();

    public void addMemento(ConfigurationMemento configurationMemento) {
        mementoList.add(configurationMemento);
    }

    public ConfigurationMemento undo() {
        if(!mementoList.isEmpty()) {
            int size = mementoList.size();
            ConfigurationMemento memento = mementoList.remove(size - 1);
            return memento;
        }
        return null;
    }
}
