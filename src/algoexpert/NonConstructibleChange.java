/*
Link to problem: https://www.algoexpert.io/questions/Non-Constructible%20Change
* Given an array of positive integers representing the values of coins in your
  possession, write a function that returns the minimum amount of change (the
  minimum sum of money) that you cannot create. The given coins can have
  any positive integer value and aren't necessarily unique (i.e., you can have
  multiple coins of the same value).
  * */

package algoexpert;

import java.util.Arrays;

public class NonConstructibleChange {

    public static void main(String[] args){
        int[] coins = new int[]{1, 2, 5};
        System.out.println("Solution nonContructibleChange_method1: "+nonContructibleChange_algoexpertSolution(coins));
    }

    public static int nonContructibleChange_algoexpertSolution(int[] coins){

        Arrays.sort(coins);
        int change = 0;
        for(int coin : coins){
            if( coin > change + 1)
                return change + 1;

            change += coin;
        }

        return change + 1;
    }
}
