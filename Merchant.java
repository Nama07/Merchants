import java.util.ArrayList;
import java.util.List;

public class Merchant {
    private String name;
    private List<itemst> items; // Items specific to this merchant

    public Merchant(String name, List<itemst> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public List<itemst> getItems() {
        return items;
    }

    public void showItems() {
        if (items.isEmpty()) {
            System.out.println(name + " has no items to sell.");
        } else {
            System.out.println("Items available from " + name + ":");
            for (itemst item : items) {
                System.out.println(item);
            }
        }
    }
}
