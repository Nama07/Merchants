import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        // Create merchants with specific items
        Merchant foodMerchant = new Merchant("Food Merchant", filterItemsByCategory(1)); // Category 1: Food
        Merchant weaponMerchant = new Merchant("Weapon Merchant", filterItemsByCategory(2)); // Category 2: Weapons

        // List of merchants
        List<Merchant> merchants = new ArrayList<>();
        merchants.add(foodMerchant);
        merchants.add(weaponMerchant);

        int choice = -1;

        while (choice != 3) {
            System.out.println("1. Visit a merchant");
            System.out.println("2. Show inventory");
            System.out.println("3. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    visitMerchant(scanner, merchants, inventory);
                    break;
                case 2:
                    System.out.println(inventory);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    private static void visitMerchant(Scanner scanner, List<Merchant> merchants, Inventory inventory) {
        System.out.println("Choose a merchant to visit:");
        for (int i = 0; i < merchants.size(); i++) {
            System.out.println((i + 1) + ". " + merchants.get(i).getName());
        }

        int merchantChoice = scanner.nextInt();
        if (merchantChoice > 0 && merchantChoice <= merchants.size()) {
            Merchant selectedMerchant = merchants.get(merchantChoice - 1);
            selectedMerchant.showItems();

            System.out.println("Enter the ID of the item you want to buy:");
            int itemId = scanner.nextInt();

            itemst itemToBuy = getItemById(selectedMerchant.getItems(), itemId);
            if (itemToBuy != null) {
                inventory.addItem(itemToBuy);
            } else {
                System.out.println("Item not found.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static itemst getItemById(List<itemst> items, int id) {
        for (itemst item : items) {
            if (item.Id == id) {
                return item;
            }
        }
        return null;
    }

    private static List<itemst> filterItemsByCategory(int category) {
        List<itemst> allItems = itemst.getAllItems();
        List<itemst> filteredItems = new ArrayList<>();

        for (itemst item : allItems) {
            if (item.Category == category) {
                filteredItems.add(item);
            }
        }

        return filteredItems;
    }
}
