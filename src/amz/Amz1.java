package amz;

import java.util.*;

public class Amz1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"2abc", "bcd", "cab"},new String[]{"dbc", "2abc", "cab", "bcd", "bcb"})));
        System.out.println(Arrays.toString(solution(new String[]{"in", "the", "spain"},new String[]{"the", "spain", "that", "the", "rain", "in", "spain", "stays", "forecast", "in", "the"})));
    }

    public static int[] solution(String[] target, String[] source){

        Boolean continue_loop     = true;
        int target_length         = target.length;
        int index                 = 0;
        int[] result_indexes      = new int[2];

        while( continue_loop ){
            for( int i = index; i < source.length - target_length; i++){
                String[] subArray = subArray( source, i, i + target_length );
                if( arrayContainsTarget(subArray, target) ){
                    result_indexes[0] = i;
                    result_indexes[1] = i + target_length - 1;
                    continue_loop = false;
                }
            }
            index++;
            target_length++;
        }

        return result_indexes;

    }

    public static Boolean arrayContainsTarget(String[] source, String[] target){
        for( String element : target){
            if( !Arrays.asList(source).contains(element)){
                return false;
            }
        }
        return true;
    }

    public static String[] subArray(String[] array, int beg, int end) {
        return Arrays.copyOfRange(array, beg, end );
    }

}
