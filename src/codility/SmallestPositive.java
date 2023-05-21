/*

* Write a function:

class Solution { public int solution(int[] A); }
that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.
Assume that:

N is an integer within the range [1..100,000]; each element of array A is an integer within the range [−1,000,000..1,000,000]. Complexity:

expected worst-case time complexity is O(N); expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
* */


package codility;

import java.util.Arrays;

public class SmallestPositive {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 6, 4, 1, 1, 1, 5}));
    }

    public static int solution(int[] arr) {
        int smallestInt = 1;

        if (arr.length == 0) return smallestInt;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == smallestInt) {
                smallestInt++;
            }
        }

        return smallestInt;
    }
}
