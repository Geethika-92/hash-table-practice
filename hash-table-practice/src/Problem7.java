import java.util.*;

public class Problem7 {

    static HashMap<String, Integer> searchMap = new HashMap<>();

    public static void addSearch(String query) {
        searchMap.put(query, searchMap.getOrDefault(query, 0) + 1);
    }

    public static void suggest(String prefix) {
        for (String key : searchMap.keySet()) {
            if (key.startsWith(prefix)) {
                System.out.println(key + " (" + searchMap.get(key) + ")");
            }
        }
    }

    public static void main(String[] args) {
        addSearch("java tutorial");
        addSearch("java download");
        addSearch("javascript basics");

        suggest("jav");
    }
}