package codility;

public class FrogRiverOne {

    private static int solution(int riverPositions, int[] times){
        boolean[] riverPositionsTaken = new boolean[riverPositions + 1];

        for(int currentTime = 0; currentTime < times.length; currentTime++){
            int pos = times[currentTime];
            if(!riverPositionsTaken[pos]){
                riverPositionsTaken[pos] = true;
                riverPositions--;
                if(riverPositions == 0)return currentTime;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(solution(5, new int[]{1,3,1,4,2,3,5,4}));
        System.out.println(solution(1, new int[]{1,1,1}));
        System.out.println(solution(3, new int[]{1,2,1}));
    }
}
