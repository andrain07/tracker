package ru.job4j.tracker;

public class StopUIAction implements UserAction {
    @Override
    public String name() {
        return "Stop UI";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
