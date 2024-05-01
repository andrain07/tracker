package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Tracker;

import java.util.Objects;

public class FindByIdActionAction implements UserAction {
    private final Output out;

    public FindByIdActionAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        out.println(Objects.requireNonNullElseGet(item, () -> "Заявка с введенным id: " + id + " не найдена."));
        return true;
    }
}
