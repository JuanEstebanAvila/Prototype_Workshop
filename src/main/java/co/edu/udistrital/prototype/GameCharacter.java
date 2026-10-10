package co.edu.udistrital.prototype;

import co.edu.udistrital.model.Inventory;

public class GameCharacter implements Prototype<GameCharacter> {

    private String name;
    private final String characterClass;
    private final Inventory inventory;

    public GameCharacter(String name, String characterClass, Inventory inventory) {
        this.name = name;
        this.characterClass = characterClass;
        this.inventory = inventory;
    }

    // Private copy constructor, with validation.
    private GameCharacter(GameCharacter other) {
        this.name = other.name;
        this.characterClass = other.characterClass;
        this.inventory = other.inventory.copy(); // deep copy
    }

    @Override
    public GameCharacter cloneObject() {
        return new GameCharacter(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return name + " (" + characterClass + ") - Inventory: " + inventory;
    }
}
