/*
Link to the problem: https://www.algoexpert.io/questions/Class%20Photos
*  It's photo day at the local school, and you're the photographer assigned to
  take class photos. The class that you'll be photographing has an even number
  of students, and all these students are wearing red or blue shirts. In fact,
  exactly half of the class is wearing red shirts, and the other half is wearing
  blue shirts. You're responsible for arranging the students in two rows before
  taking the photo. Each row should contain the same number of the students and
  should adhere to the following guidelines:

  -All students wearing red shirts must be in the same row.
  -All students wearing blue shirts must be in the same row.
  -Each student in the back row must be strictly taller than the student
    directly in front of them in the front row.

  You're given two input arrays: one containing the heights of all the students
  with red shirts and another one containing the heights of all the students
  with blue shirts. These arrays will always have the same length, and each
  height will be a positive integer. Write a function that returns whether or
  not a class photo that follows the stated guidelines can be taken.
  Note: you can assume that each class has at least 2 students.*/

package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ClassPhotos {

    public static void main(String[] args){
        ArrayList<Integer> redShirtHeights = new ArrayList<Integer>();
        redShirtHeights.add(5);
        redShirtHeights.add(8);
        redShirtHeights.add(1);
        redShirtHeights.add(3);
        redShirtHeights.add(4);

        ArrayList<Integer> blueShirtHeights = new ArrayList<Integer>();
        blueShirtHeights.add(6);
        blueShirtHeights.add(9);
        blueShirtHeights.add(2);
        blueShirtHeights.add(4);
        blueShirtHeights.add(5);

        ArrayList<Integer> redShirtHeights1 = new ArrayList<Integer>();
        redShirtHeights1.add(6);

        ArrayList<Integer> blueShirtHeights1 = new ArrayList<Integer>();
        blueShirtHeights1.add(6);

        System.out.println("classPhotos_arrayVesion: "+classPhotos_arrayVesion(redShirtHeights, blueShirtHeights));
        System.out.println("classPhotos_arrayVesion: "+classPhotos_arrayVesion(redShirtHeights1, blueShirtHeights1));
        System.out.println();
        System.out.println("classPhotos_listVesion: "+classPhotos_listVesion(redShirtHeights, blueShirtHeights));
        System.out.println("classPhotos_listVesion: "+classPhotos_listVesion(redShirtHeights1, blueShirtHeights1));
    }

    public static boolean classPhotos_listVesion(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights){
        Collections.sort(redShirtHeights, Collections.reverseOrder());
        Collections.sort(blueShirtHeights, Collections.reverseOrder());

        int currentBigger = -1;
        for(int i = 0; i < redShirtHeights.size(); i++){
            if( redShirtHeights.get(i) == blueShirtHeights.get(i) ){
                return false;
            }if( redShirtHeights.get(i) > blueShirtHeights.get(i) ){
                if(currentBigger == -1)
                    currentBigger = 0;
                else if( currentBigger == 1)
                    return false;
            }else{
                if(currentBigger == -1)
                    currentBigger = 1;
                else if( currentBigger == 0)
                    return false;
            }
        }

        return true;
    }

    public static boolean classPhotos_arrayVesion(ArrayList<Integer> redShirtHeights_al, ArrayList<Integer> blueShirtHeights_al){
        Integer[] redShirtsHeights = new Integer[redShirtHeights_al.size()];
        Integer[] blueShirtHeights = new Integer[blueShirtHeights_al.size()];
        redShirtsHeights =  redShirtHeights_al.toArray(redShirtsHeights);
        blueShirtHeights =  blueShirtHeights_al.toArray(blueShirtHeights);

        Arrays.sort(redShirtsHeights);
        Arrays.sort(blueShirtHeights);

        int currentBigger = -1;
        for(int i = 0; i < redShirtsHeights.length; i++){
            if( redShirtsHeights[i] == blueShirtHeights[i] ){
                return false;
            }if( redShirtsHeights[i] > blueShirtHeights[i] ){
                if(currentBigger == -1)
                    currentBigger = 0;
                else if( currentBigger == 1)
                    return false;
            }else{
                if(currentBigger == -1)
                    currentBigger = 1;
                else if( currentBigger == 0)
                    return false;
            }
        }

        return true;
    }
}
