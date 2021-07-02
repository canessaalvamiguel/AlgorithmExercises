package amazon;

import java.util.*;

public class AmazonCode2 {
    public static void main(String[] args) {
        System.out.println(solution("qwerccw23",3));
        System.out.println(solution("inthespainn",4));
    }

    public static List<String> solution(String word, int k){

        int target_length   = k;
        List results        = new ArrayList<String>();

        for( int i = 0; i < word.length() - target_length + 1; i++){
            String subString = word.substring(i, i + target_length);
            if( onlyOneCharacterIsRepeated(subString) ){
                results.add(subString);
            }
        }
        return results;

    }

    public static Boolean onlyOneCharacterIsRepeated(String source){

        Map<Character, Integer> characters = new HashMap<>();

        for (int i = 0; i < source.length(); i++){
            Character key = source.charAt(i);
            if( characters.containsKey(key)){
                characters.put(key, characters.get(key) + 1);
            }else{
                characters.put(key,1);
            }
        }

        Boolean hasOneCharacterRepeated = false;
        for (Map.Entry<Character, Integer> entry : characters.entrySet()) {
            Integer counter = Integer.valueOf(entry.getValue().toString());
            if( counter == 2 && hasOneCharacterRepeated == false){
                hasOneCharacterRepeated = true;
            }else if( counter == 2 && hasOneCharacterRepeated == true){
                return false;
            }else if( counter > 1){
                return false;
            }
        }

        return hasOneCharacterRepeated;
    }

}
