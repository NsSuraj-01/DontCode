package Practise;

import java.util.*;
public class Day12 {

    // count number of stop words and sort based on words
    public static void count(String str, String[] words) {
        int cnt = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for(String s : words) {
            s = s.toLowerCase();
            map.put(s, cnt);
        }

        String[] sentence = str.split(" ");

        for(String word : sentence) {
            if(map.containsKey(word)) {
                int count = map.get(word);
                map.put(word, count+1);
            }
        }
        System.out.println(map);

        ArrayList<String> res = new ArrayList<>();
        Set<String> keys = map.keySet();

        for(String key : keys) {
            res.add(key);
        }

        Collections.sort(res);
        System.out.println(res);
    }

    public static void main(String[] args) {
        String str = "In the bustling city, a young woman with a book in her hand strolled down the crowded street. She walked past the park and through the market, stopping at the café on the corner.";
        String[] stopwords = {"an", "of", "the", "and", "as", "a", "on","with","in"};

        count(str, stopwords);

    }
}
