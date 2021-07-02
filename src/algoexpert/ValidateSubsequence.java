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
