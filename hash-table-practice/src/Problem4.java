import java.util.*;

public class Problem4 {

    static HashMap<String, Set<String>> ngramMap = new HashMap<>();

    public static void addDocument(String docId, String text) {
        String[] words = text.split(" ");

        for (int i = 0; i < words.length - 2; i++) {
            String gram = words[i] + " " + words[i+1] + " " + words[i+2];

            ngramMap.putIfAbsent(gram, new HashSet<>());
            ngramMap.get(gram).add(docId);
        }
    }

    public static void checkSimilarity(String text) {
        String[] words = text.split(" ");
        int matches = 0;

        for (int i = 0; i < words.length - 2; i++) {
            String gram = words[i] + " " + words[i+1] + " " + words[i+2];

            if (ngramMap.containsKey(gram)) {
                matches++;
            }
        }

        System.out.println("Matching n-grams: " + matches);
    }

    public static void main(String[] args) {
        addDocument("doc1", "this is a simple plagiarism detection test");

        checkSimilarity("this is a simple plagiarism test");
    }
}