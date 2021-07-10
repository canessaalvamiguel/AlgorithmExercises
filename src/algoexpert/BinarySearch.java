/*
Link to problem: https://www.algoexpert.io/questions/Binary%20Search
* Write a function that takes in a sorted array of integers as well as a target
  integer. The function should use the Binary Search algorithm to determine if
  the target integer is contained in the array and should return its index if it
  is, otherwise -1.


  If you're unfamiliar with Binary Search, we recommend watching the Conceptual
  Overview section of this question's video explanation before starting to code.

  Sample Input
  array = [0, 1, 21, 33, 45, 45, 61, 71, 72, 73]
  target = 33

  Sample Output
  3*/
package algoexpert;

public class BinarySearch {

    public static void main(String[] args){
        int[] array = new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int target = 730;

        System.out.println("binarySearch_iterative result: "+binarySearch_iterative(array, target));
        System.out.println("binarySearch_recursive result: "+binarySearch_recursive(array, target));
    }

    private static int binarySearch_recursive(int[] array, int target) {
        return binarySearch_recursive(array, target, 0, array.length - 1);
    }

    private static int binarySearch_recursive(int[] array, int target, int left, int right) {
        if( left > right){
            return -1;
        }

        int middle = (left + right) / 2;
        int middle_number = array[middle];

        if(middle_number == target){
            return middle;
        }else if(middle_number > target){
            return binarySearch_recursive(array, target, left, middle - 1);
        }else{
            return binarySearch_recursive(array, target, middle + 1, right);
        }
    }

    public static int binarySearch_iterative(int[] array, int target) {

        int left = 0;
        int right = array.length - 1;

        while(left <= right){
            int middle = (left + right) / 2;
            int middle_number = array[middle];

            if(middle_number == target){
                return middle;
            }else if(middle_number > target){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }

        return -1;
    }
}
