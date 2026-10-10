package co.edu.udistrital.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventory {

    private final List<String> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public Inventory(List<String> items) {
        this.items = new ArrayList<>(items);
    }

    // Copy constructor
    public Inventory(Inventory other) {
        this.items = new ArrayList<>(other.items);
    }

    public void addItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }

    public Inventory copy() {
        return new Inventory(this);
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
