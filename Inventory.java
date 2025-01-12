import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> itemCounts;

    public Inventory() {
        itemCounts = new HashMap<>();
    }


    // Add an item to the inventory

    public void addItem(itemst item) {
        itemCounts.put(item.Name, itemCounts.getOrDefault(item.Name, 0) + 1);
        System.out.println(item.Name + " has been added to your inventory.");
    }


    // show inventory
    
    public void showInventory() {
        if (itemCounts.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your inventory contains:");
            for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
                String itemName = entry.getKey();
                int quantity = entry.getValue();
                if (quantity > 1) {
                    System.out.println(quantity + "x " + itemName);
                } else {
                    System.out.println(itemName); 
                }
            }
        }
    }


    @Override
        public String toString() {
            if (itemCounts.isEmpty()) {
                return "Your inventory is empty.";
            }
            String inventoryContents = "\n";
            for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
                String itemName = entry.getKey();
                int quantity = entry.getValue();
                if (quantity > 1) {
                    inventoryContents += quantity + "x " + itemName + "\n"; 
                } else {
                    inventoryContents += itemName + "\n"; 
                }
            }
            return inventoryContents;
        }
    }
