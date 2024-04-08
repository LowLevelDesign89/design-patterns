package com.app.memento;

public class Client {
    public static void main(String[] args) {
        ConfigurationCaretaker configurationCaretaker = new ConfigurationCaretaker();
        ConfigurationOriginator configurationOriginator = new ConfigurationOriginator(5, 10);
        ConfigurationMemento configurationMemento = configurationOriginator.createMemento();

        configurationCaretaker.addMemento(configurationMemento);

        configurationOriginator.setHeight(7);
        configurationOriginator.setWidth(12);


        configurationMemento = configurationOriginator.createMemento();
        configurationCaretaker.addMemento(configurationMemento);

        configurationOriginator.setHeight(9);
        configurationOriginator.setWidth(14);

        System.out.println("Current Height : " + configurationOriginator.getHeight() + " <-> Current Width: " + configurationOriginator.getWidth());

        ConfigurationMemento lastConfig = configurationCaretaker.undo();
        configurationOriginator.restoreMemento(lastConfig);

        System.out.println("Current Height : " + configurationOriginator.getHeight() + " <-> Current Width: " + configurationOriginator.getWidth());
    }
}
