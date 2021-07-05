/*
Link to the problem: https://www.algoexpert.io/questions/Minimum%20Waiting%20Time
*  You're given a non-empty array of positive integers representing the amounts
  of time that specific queries take to execute. Only one query can be executed
  at a time, but the queries can be executed in any order.

  A query's waiting time is defined as the amount of time that it must
  wait before its execution starts. In other words, if a query is executed
  second, then its waiting time is the duration of the first query; if a query
  is executed third, then its waiting time is the sum of the durations of the
  first two queries.


  Write a function that returns the minimum amount of total waiting time for all
  of the queries. For example, if you're given the queries of durations
  [1, 4, 5], then the total waiting time if the queries were
  executed in the order of [5, 1, 4] would be
  (0) + (5) + (5 + 1) = 11. The first query of duration
  5 would be executed immediately, so its waiting time would be
  0, the second query of duration 1 would have to wait
  5 seconds (the duration of the first query) to be executed, and
  the last query would have to wait the duration of the first two queries before
  being executed.

Note: you're allowed to mutate the input array.
* */

package algoexpert;

import java.util.Arrays;

public class MinimunWaitingTime {
    public static void main(String[] args){
        int[] queries = new int[]{5, 1, 4};
        System.out.println("minimunWaitingTime: "+minimunWaitingTime(queries));
        System.out.println("minimunWaitingTime_algoexpertSolution: "+minimunWaitingTime_algoexpertSolution(queries));

        int[] queries1 = new int[]{6, 2, 3, 2, 1};
        System.out.println("minimunWaitingTime: "+minimunWaitingTime(queries1));
        System.out.println("minimunWaitingTime_algoexpertSolution: "+minimunWaitingTime_algoexpertSolution(queries1));
    }

    public static int minimunWaitingTime_algoexpertSolution(int[] queries){
        //O(nlogn) time | O(1) space
        Arrays.sort(queries);

        int totalWaitingTime = 0;
        for(int i = 0; i < queries.length; i++){
            int queriesLeft = queries.length - (i + 1);
            totalWaitingTime += queries[i] * queriesLeft;
        }

        return totalWaitingTime;
    }

    public static int minimunWaitingTime(int[] queries){
        //O(nlogn) time | O(1) space
        Arrays.sort(queries);

        int totalWaitingTime = 0;
        int previousSum = 0;
        for(int i = 1; i < queries.length; i++){
            int localWaitingTime = queries[i - 1] + previousSum;
            previousSum = localWaitingTime;
            totalWaitingTime += localWaitingTime;
        }

        return totalWaitingTime;
    }

}
