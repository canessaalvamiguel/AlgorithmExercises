/*
* You're given two non-empty strings: a big string and a small string. Write a
  function that returns the smallest substring in the big string that contains
  all of the small string's characters.

  Note that:
    The substring can contain other characters not found in the small string.
    The characters in the substring don't have to be in the same order as they
    appear in the small string.
    If the small string has duplicate characters, the substring has to contain
    those duplicate characters (it can also contain more, but not fewer).

 You can assume that there will only be one relevant smallest substring.

 Sample Input
    bigString = "abcd$ef$axb$c$"
    smallString = "$$abf"

 Sample Output
  "f$axb$"
  * */

package algoexpert;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringConatining {

    public static void main(String[] args){
        String bigString = "abcd$ef$axb$c$";
        String smallString = "$$abf";

        System.out.println("smallestSubstringContaining: "+smallestSubstringContaining( bigString, smallString));
    }

    public static String smallestSubstringContaining(String bigString, String smallString) {
        int maybeSize = smallString.length();
        String result = "";

        for(int i = 0; i < bigString.length() ; i++){
            for(int j = maybeSize; i + j <=  bigString.length(); j++){
                String currentSubString = bigString.substring(i, i+j);
                if( containsAllCharacters(currentSubString, smallString) ){
                    if(!result.equals("") && currentSubString.length() < result.length()){
                        result = currentSubString;
                    }
                    else if(result.equals("")){
                        result = currentSubString;
                    }
                }
            }
        }

        return result;
    }

    public static boolean containsAllCharacters(String bigSubString, String smallString){
        int founds = 0;
        Map<Character, Integer> smallStringFrecuencies = new HashMap<>();

        for(int i = 0; i < smallString.length(); i++){
            char currentChar = smallString.charAt(i);
            smallStringFrecuencies.put(currentChar, smallStringFrecuencies.getOrDefault(currentChar, 0) + 1);
            if(bigSubString.indexOf(currentChar) != -1){
                founds++;
            }
        }

        if(founds == smallString.length() ){
            Map<Character, Integer> bigSubStrigFrecuency = new HashMap<>();
            for(int i = 0; i < bigSubString.length(); i++){
                char currentChar = bigSubString.charAt(i);
                bigSubStrigFrecuency.put(currentChar, bigSubStrigFrecuency.getOrDefault(currentChar, 0) + 1);
            }

            for(Map.Entry smallStringCharFrecuency : smallStringFrecuencies.entrySet()){
                int bigSubStringCharFrequency = bigSubStrigFrecuency.getOrDefault(smallStringCharFrecuency.getKey(), 0);
                if(bigSubStringCharFrequency < (int)smallStringCharFrecuency.getValue()){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }
}
