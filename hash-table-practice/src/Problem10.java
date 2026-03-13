import java.util.HashMap;

public class Problem10 {

    static HashMap<String, String> L1Cache = new HashMap<>();
    static HashMap<String, String> L2Cache = new HashMap<>();

    public static String getVideo(String id) {

        if (L1Cache.containsKey(id)) {
            return "L1 Cache Hit: " + L1Cache.get(id);
        }

        if (L2Cache.containsKey(id)) {
            String data = L2Cache.get(id);
            L1Cache.put(id, data);
            return "L2 Cache Hit, promoted to L1: " + data;
        }

        String data = "VideoData_" + id;
        L2Cache.put(id, data);

        return "Fetched from database: " + data;
    }

    public static void main(String[] args) {

        System.out.println(getVideo("video1"));
        System.out.println(getVideo("video1"));
    }
}