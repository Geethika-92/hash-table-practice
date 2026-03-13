import java.util.HashMap;
import java.util.HashSet;

public class Problem5 {

    static HashMap<String, Integer> pageViews = new HashMap<>();
    static HashMap<String, HashSet<String>> uniqueVisitors = new HashMap<>();

    public static void processEvent(String url, String userId) {

        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        uniqueVisitors.putIfAbsent(url, new HashSet<>());
        uniqueVisitors.get(url).add(userId);
    }

    public static void showStats() {
        for (String url : pageViews.keySet()) {
            System.out.println(url + " Views: " + pageViews.get(url) +
                    " Unique Visitors: " + uniqueVisitors.get(url).size());
        }
    }

    public static void main(String[] args) {

        processEvent("/news", "user1");
        processEvent("/news", "user2");
        processEvent("/sports", "user1");

        showStats();
    }
}