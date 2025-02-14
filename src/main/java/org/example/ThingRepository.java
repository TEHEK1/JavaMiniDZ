package org.example;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ThingRepository {
    private final List<IInventory> inventory = new ArrayList<>();

    public void addThing(Thing thing) {
        inventory.add(thing);
    }

    public List<IInventory> getAllInventory() {
        return inventory;
    }
}