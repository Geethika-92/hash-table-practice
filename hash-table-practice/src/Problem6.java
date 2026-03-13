import java.util.HashMap;

public class Problem6 {

    static HashMap<String, Integer> requests = new HashMap<>();
    static int LIMIT = 5;

    public static void checkRequest(String clientId) {
        int count = requests.getOrDefault(clientId, 0);

        if (count < LIMIT) {
            requests.put(clientId, count + 1);
            System.out.println("Request allowed. Remaining: " + (LIMIT - (count + 1)));
        } else {
            System.out.println("Rate limit exceeded!");
        }
    }

    public static void main(String[] args) {
        checkRequest("client1");
        checkRequest("client1");
        checkRequest("client1");
        checkRequest("client1");
        checkRequest("client1");
        checkRequest("client1");
    }
}