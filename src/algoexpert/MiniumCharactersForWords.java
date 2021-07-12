package algoexpert;

import java.util.*;

public class MiniumCharactersForWords {

    public static void main(String[] args){
        String[] words = new String[]{"this", "that", "did", "deed", "them!", "a"};

        System.out.println("minimumCharactersForWords: "+ Arrays.toString(minimumCharactersForWords(words)));
    }

    public static char[] minimumCharactersForWords(String[] words) {
        Map<Character, Integer> letter_Maxs = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            Map<Character, Integer> letter_currentMaxs = new HashMap<>();
            for(int j = 0; j < words[i].length(); j++){
                Character current_char = words[i].charAt(j);
                letter_currentMaxs.put(current_char, letter_currentMaxs.getOrDefault(current_char, 0) + 1);

                if(letter_Maxs.getOrDefault(current_char, 0) < letter_currentMaxs.get(current_char)){
                    letter_Maxs.put(current_char, letter_currentMaxs.get(current_char));
                }
            }
        }

        List result_list = new ArrayList<Character>();

        for(Map.Entry a : letter_Maxs.entrySet()){
            int times = (int)a.getValue();
            for(int j = 0; j < times; j++){
                result_list.add(a.getKey());
            }
        }

        char[] result = new char[result_list.size()];
        for(int i = 0; i < result_list.size(); i++){
            result[i] = (char)result_list.get(i);
        }
        return result;
    }
}
