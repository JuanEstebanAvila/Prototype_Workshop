package co.edu.udistrital.main;

import co.edu.udistrital.model.Inventory;
import co.edu.udistrital.prototype.GameCharacter;
import co.edu.udistrital.registry.PrototypeRegistry;

public class Main {

    public static void main(String[] args) {
        PrototypeRegistry registry = new PrototypeRegistry();

        // Base prototypes
        Inventory warriorInventory = new Inventory();
        warriorInventory.addItem("Hammer");
        registry.registerPrototype("Warrior", new GameCharacter("Warrior", "Warrior", warriorInventory));

        Inventory mageInventory = new Inventory();
        mageInventory.addItem("Mana Potion");
        mageInventory.addItem("Spellbook");
        registry.registerPrototype("Mage", new GameCharacter("Mage", "Mage", mageInventory));

        System.out.println("Registered prototypes");
        System.out.println(registry.getPrototypeForInspection("Warrior"));
        System.out.println(registry.getPrototypeForInspection("Mage"));

        // Cloning
        GameCharacter warriorCopy = registry.getCopy("Warrior");
        warriorCopy.setName("Warrior-Copy");

        GameCharacter mageCopy = registry.getCopy("Mage");
        mageCopy.setName("Mage-Copy");

        System.out.println("\nClones created");
        System.out.println(warriorCopy);
        System.out.println(mageCopy);

        // Modify the copy's inventory
        warriorCopy.getInventory().addItem("Shield");

        System.out.println("\nAfter adding 'Shield' to Warrior-Copy inventory");
        System.out.println(warriorCopy);
        System.out.println(registry.getPrototypeForInspection("Warrior"));

        boolean independent = !registry.getPrototypeForInspection("Warrior").getInventory().getItems().contains("Shield");
        System.out.println("Original inventory unchanged (deep copy): " + independent);

        // Non-existent prototype
        System.out.println("\nRequesting a non-existent prototype");
        GameCharacter missing = registry.getCopy("Archer");
        if (missing == null) {
            System.out.println("Prototype 'Archer' does not exist, nothing was cloned.");
        }
    }
}
