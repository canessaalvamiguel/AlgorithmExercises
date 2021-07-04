/*
* Link to the problem: https://www.algoexpert.io/questions/Validate%20Subsequence
* Given two non-empty arrays of integers, write a function that determines
  whether the second array is a subsequence of the first one.

  A subsequence of an array is a set of numbers that aren't necessarily adjacent
  in the array but that are in the same order as they appear in the array. For
  instance, the numbers [1, 3, 4] form a subsequence of the array
  [1, 2, 3, 4], and so do the numbers [2, 4]. Note
  that a single number in an array and the array itself are both valid
  subsequences of the array.
* */

package algoexpert;

import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {
    public static void main(String[] args){
        List array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List sequence = Arrays.asList(1, 6, -1, 10);

        System.out.println(validateSubsequence_bruteForce(array, sequence));
    }

    public static boolean validateSubsequence_bruteForce(List<Integer> array, List<Integer> sequence){
        int sequence_index = 0;
        for(int i = 0; i < array.size(); i++){
            if( sequence.get(sequence_index) == array.get(i) ){
                sequence_index++;
            }
        }

        return sequence_index == sequence.size();
    }
}
