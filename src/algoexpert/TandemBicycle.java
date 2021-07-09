/*
Link to problem: https://www.algoexpert.io/questions/Tandem%20Bicycle
*  A tandem bicycle is a bicycle that's operated by two people: person A and
  person B. Both people pedal the bicycle, but the person that pedals faster
  dictates the speed of the bicycle. So if person A pedals at a speed of
  5, and person B pedals at a speed of 4, the tandem
  bicycle moves at a speed of 5 (i.e.,
  tandemSpeed = max(speedA, speedB)).


  You're given two lists of positive integers: one that contains the speeds of
  riders wearing red shirts and one that contains the speeds of riders wearing
  blue shirts. Each rider is represented by a single positive integer, which is
  the speed that they pedal a tandem bicycle at. Both lists have the same
  length, meaning that there are as many red-shirt riders as there are
  blue-shirt riders. Your goal is to pair every rider wearing a red shirt with a
  rider wearing a blue shirt to operate a tandem bicycle.


  Write a function that returns the maximum possible total speed or the minimum
  possible total speed of all of the tandem bicycles being ridden based on an
  input parameter, fastest. If fastest = true, your
  function should return the maximum possible total speed; otherwise it should
  return the minimum total speed.


  "Total speed" is defined as the sum of the speeds of all the tandem bicycles
  being ridden. For example, if there are 4 riders (2 red-shirt riders and 2
  blue-shirt riders) who have speeds of 1, 3, 4, 5, and if they're
  paired on tandem bicycles as follows: [1, 4], [5, 3], then the
  total speed of these tandem bicycles is 4 + 5 = 9.

Sample Input
* redShirtSpeeds = [5, 5, 3, 9, 2]
* blueShirtSpeeds = [3, 6, 7, 2, 1]
* fastest = true
* Sample Output: 32*/

package algoexpert;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class TandemBicycle {

    public static void main(String[] args){
        int[] redShirtSpeeds = new int[]{5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = new int[]{3, 6, 7, 2, 1};
        boolean fastest = true;

        System.out.println("minimunWaitingTime: "+tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest));
    }

    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest){

        //O(nlog(n)) time | O(1) space
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        if( fastest ){
            reverseArray(blueShirtSpeeds);
        }

        int sum = 0;
        for(int i = 0; i < redShirtSpeeds.length; i++){
            Integer max_value = Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
            sum+=max_value;
        }

        return sum;
    }

    public static void reverseArray(int[] array){
        int[] tempArray = new int[array.length];

        for (int i = 0; i < array.length; i++){
            tempArray[i] = array[ array.length - i - 1];
        }

        for (int i = 0; i < array.length; i++){
            array[i] = tempArray[i];
        }
    }
}
