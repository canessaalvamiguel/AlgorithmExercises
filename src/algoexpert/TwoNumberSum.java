/*
 * Link to problem: https://www.algoexpert.io/questions/Two%20Number%20Sum
 * Write a function that takes in a non-empty array of distinct integers and an
  integer representing a target sum. If any two numbers in the input array sum
  up to the target sum, the function should return them in an array, in any
  order. If no two numbers sum up to the target sum, the function should return
  an empty array.

  Note that the target sum has to be obtained by summing two different integers
  in the array; you can't add a single integer to itself in order to obtain the
  target sum.

  You can assume that there will be at most one pair of numbers summing up to
  the target sum.
 * */

package algoexpert;

import java.util.Arrays;

public class TwoNumberSum {
    public static void main(String[] args){
        int[] array = {3,5,-4,8,11,1,-1,6};
        int targetSum =11;

        long start1 = System.nanoTime();
        System.out.println("twoNumberSum_bruteForce: "+Arrays.toString(twoNumberSum_bruteForce(array,targetSum)));
        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds (twoNumberSum_bruteForce): "+ (end1-start1)+"\n");

        long start2 = System.nanoTime();
        System.out.println("twoNumberSum_mostOptimal: "+Arrays.toString(twoNumberSum_mostOptimal(array,targetSum)));
        long end2 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds (twoNumberSum_mostOptimal): "+ (end2-start2)+"\n");

        System.out.println("Difference between twoNumberSum_bruteForce and twoNumberSum_mostOptimal: "+((end1-start1)-(end2-start2)));
    }

    private static int[] twoNumberSum_mostOptimal(int[] array, int targetSum) {
        //O(nlog(n)) time | O(1) space
        int left = 0;
        int rigth = array.length - 1;

        Arrays.sort(array);

        while(left < rigth){
            int currentSum = array[left] + array[rigth];
            if( currentSum == targetSum ){
                return new int[] { array[left], array[rigth]};
            }else if(currentSum < targetSum){
                left++;
            }else if(currentSum > targetSum){
                rigth--;
            }
        }

        return null;
    }

    public static int[] twoNumberSum_bruteForce(int[] array, int targetSum){
        //O(n^2) time | O(1) space
        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++){
                if( array[i] + array[j] == targetSum)
                    return new int[] { array[i], array[j] };
            }
        }
        return null;
    }
}
