import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class itemst {
    String Name;    
    int Cena;      
    int Stock;      
    int Id;        
    int Category;   
    String Seazon;  



    // List to store all items

    private static List<itemst> allItems = new ArrayList<>();

    public itemst(String name, int cena, int stock, int id, int category, String seazon) {
        this.Name = name;
        this.Cena = cena;
        this.Stock = stock;
        this.Id = id;
        this.Category = category;
        this.Seazon = seazon;
        allItems.add(this);
    }



    // Method to get a random item

    public static itemst randomItem() {
        Random random = new Random();
        if (allItems.isEmpty()) {
            throw new IllegalStateException("No items available to select.");
        }
        return allItems.get(random.nextInt(allItems.size()));
    }


    // getter for all items list

    public static List<itemst> getAllItems() {
        return allItems;

    }



    //print items in a formatted way

    @Override
    public String toString() {
        return  
                Name + 
                "; Price = " + Cena +
                "; Stock = " + Stock +
                "; Id = " + Id +
                "; Category = " + Category +
                "; Season = " + Seazon;
    }
}

