package others;

import java.util.*;
import java.util.stream.Stream;

public class FrecuencyOrder {
    public static void main(String[] args) {

        String result = frecuencyOrder("cccaaaceeca");
        System.out.println(result);
    }

    private static String frecuencyOrder(String word){


        Map<Character,Integer> map = new HashMap();

        for(char letter : word.toCharArray() ){
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }

        List<String> result = new ArrayList<>();


        map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(el -> {
                    for (int i = 0; i < el.getValue(); i++) {
                        result.add(el.getKey().toString());
                    }
                });

        return String.join("", result);
    }
}
