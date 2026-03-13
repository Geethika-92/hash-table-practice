import java.util.HashMap;

public class Problem2 {

    static HashMap<String, Integer> inventory = new HashMap<>();

    public static void addProduct(String productId, int stock) {
        inventory.put(productId, stock);
    }

    public static void purchase(String productId) {
        if (inventory.containsKey(productId) && inventory.get(productId) > 0) {
            inventory.put(productId, inventory.get(productId) - 1);
            System.out.println("Purchase successful. Remaining stock: " + inventory.get(productId));
        } else {
            System.out.println("Out of stock!");
        }
    }

    public static void main(String[] args) {
        addProduct("IPHONE15", 5);

        purchase("IPHONE15");
        purchase("IPHONE15");
        purchase("IPHONE15");
    }
}