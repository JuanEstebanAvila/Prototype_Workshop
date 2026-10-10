package co.edu.udistrital.registry;

import java.util.HashMap;
import java.util.Map;

import co.edu.udistrital.prototype.GameCharacter;

public class PrototypeRegistry {

    private final Map<String, GameCharacter> prototypes = new HashMap<>();

    public void registerPrototype(String key, GameCharacter character) {
        prototypes.put(key, character);
    }

    public boolean hasPrototype(String key) {
        return prototypes.containsKey(key);
    }

    // Returns a clone of the prototype, never the original. Null if the key is unknown.
    public GameCharacter getCopy(String key) {
        GameCharacter prototype = prototypes.get(key);
        if (prototype == null) {
            return null;
        }
        return prototype.cloneObject();
    }

    // Read-only access for inspecting the stored prototype.
    public GameCharacter getPrototypeForInspection(String key) {
        return prototypes.get(key);
    }
}
