package algoexpert;

import java.util.Arrays;

public class SortedSquaredArray {

    public static void main(String[] args){
        int[] array = {1, 2, 3, 5, 6, 8, 9};

        long start1 = System.nanoTime();
        System.out.println("sortedSquaredArray: "+ Arrays.toString(sortedSquaredArray_method1(array)));
        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds (sortedSquaredArray_method1): "+ (end1-start1)+"\n");

        long start2 = System.nanoTime();
        System.out.println("sortedSquaredArray: "+ Arrays.toString(sortedSquaredArray_method2(array)));
        long end2 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds (sortedSquaredArray_method2): "+ (end2-start2)+"\n");

        System.out.println("Difference between sortedSquaredArray_method1 and sortedSquaredArray_method2: "+((end1-start1)-(end2-start2)));
    }

    public static int[] sortedSquaredArray_method2(int[] array){

        //O(n) time | O(n) space
        int[] sortedResult = new int[array.length];
        int left = 0;
        int rigth = array.length - 1;

        for (int i = array.length - 1; i >= 0; i--){
            if(Math.abs(array[left]) > Math.abs(array[rigth])){
                sortedResult[i] = array[left] * array[left];
                left++;
            }else{
                sortedResult[i] = array[rigth] * array[rigth];
                rigth--;
            }
        }

        return sortedResult;
    }

    public static int[] sortedSquaredArray_method1(int[] array){

        //O(nlogn) time | O(n) space
        int[] result = new int[array.length];
        for (int index = 0; index < array.length; index++){
            int newValue = array[index] * array[index];
            result[index] = newValue;
        }

        Arrays.sort(result);
        return result;
    }
}
