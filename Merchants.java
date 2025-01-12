import java.util.Scanner;

public class Merchants {
    private Scanner scanner;
    Inventory inventory = new Inventory();

    public Merchants() {
        scanner = new Scanner(System.in);
    }


    public void start() {
        System.out.println("Hi, I am Merchant Jenkins!");
        System.out.println("How can I help you?");
        int choice = -1;

        while (choice != 3) {
            showMenu();
            choice = scanner.nextInt();
            processChoice(choice);
        }

        System.out.println("Goodbye!");
    }



    // merchants interactions written out

    private void showMenu() {
        System.out.println("1. See available items");
        System.out.println("2. Buy an item");
        System.out.println("3. Exit");
    }

    
    private void processChoice(int choice) {
        switch (choice) {
            case 1:
                showAvailableItems();
                break;

            case 2:
                buyItem();
                break;

            case 3:
                break;

            default:
                System.out.println("Invalid choice. Try again.");
        }
    }


    private void showAvailableItems() {
        System.out.println("Available items:");
        for (itemst item : itemst.getAllItems()) {
            System.out.println(item);
        }
    }



    //merchants purchasing interactions

    private void buyItem() {
        System.out.println("Enter item ID:");
        int itemId = scanner.nextInt();
        itemst item = getItemById(itemId);
        if (item != null) {
            System.out.println("You Bought: " + item);
            UserStats.Coins -= item.Cena;
            System.out.println("You have " + UserStats.Coins + " coins left.");
            inventory.addItem(item);
            System.out.println("Your inventory now contains:" + inventory);
            item.Stock -= 1;
        } else {
            System.out.println("Item with ID " + itemId + " not found.");
        }
    }




    //get item by id

    private itemst getItemById(int id) {
        for (itemst item : itemst.getAllItems()) {
            if (item.Id == id) {
                return item;
            }
        }
        return null;
    }
}
