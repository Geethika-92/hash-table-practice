import java.util.HashMap;

class DNSEntry {
    String ip;
    long expiryTime;

    DNSEntry(String ip, long ttl) {
        this.ip = ip;
        this.expiryTime = System.currentTimeMillis() + ttl;
    }
}

public class Problem3 {

    static HashMap<String, DNSEntry> cache = new HashMap<>();

    public static void addDomain(String domain, String ip, long ttl) {
        cache.put(domain, new DNSEntry(ip, ttl));
    }

    public static void resolve(String domain) {
        if (cache.containsKey(domain)) {
            DNSEntry entry = cache.get(domain);
            if (System.currentTimeMillis() < entry.expiryTime) {
                System.out.println("Cache HIT: " + entry.ip);
            } else {
                System.out.println("Cache EXPIRED");
                cache.remove(domain);
            }
        } else {
            System.out.println("Cache MISS");
        }
    }

    public static void main(String[] args) {
        addDomain("google.com", "172.217.14.206", 5000);
        resolve("google.com");
    }
}