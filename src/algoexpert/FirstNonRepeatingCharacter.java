/*
Link to problem: https://www.algoexpert.io/questions/First%20Non-Repeating%20Character
* Write a function that takes in a string of lowercase English-alphabet letters
  and returns the index of the string's first non-repeating character.

  The first non-repeating character is the first character in a string that
  occurs only once.

  If the input string doesn't have any non-repeating characters, your function
  should return -1.

  Sample Input
  string = "abcdcaf"

  Sample Output
  1// The first non-repeating character is "b" and is found at index 1.*/
package algoexpert;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args){
        String string = "faadabcbbebdf";
        System.out.println("firstNonRepeatingCharacter_method2 result: "+firstNonRepeatingCharacter_method2( string));
    }

    public static int firstNonRepeatingCharacter_method2(String string) {
        //O(n) time | O(1) space
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < string.length(); i++){
            Character character = string.charAt(i);
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        for (int i = 0; i < string.length(); i++){
            Character character = string.charAt(i);
            if( map.get(character) == 1){
                return i;
            }
        }

        return -1;
    }
}
