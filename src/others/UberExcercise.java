package others;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class UberExcercise {

    public static final String[] rides = {"UberX", "UberXL", "UberPlus", "UberBlack", "UberSuv"};

    public static void main(String[] args) {
        float length = 30;
        float[] fares = {0.3f, 0.5f, 0.7f, 1f, 1.31f};
        float credit = 20f;

        long startTime = System.nanoTime();
        String solution = solution(length, fares, credit);
        long endTime = System.nanoTime();
        System.out.println("Solution with method 1 is: " + solution + " duration was : " + (endTime - startTime));

        startTime = System.nanoTime();
        String solution2 = solution2(length, fares, credit);
        endTime = System.nanoTime();
        System.out.println("Solution with method 2 is: " + solution2 + " duration was : " + (endTime - startTime));

        startTime = System.nanoTime();
        String solution3 = solution3(length, fares, credit);
        endTime = System.nanoTime();
        System.out.println("Solution with method 3 is: " + solution3 + " duration was : " + (endTime - startTime));

        startTime = System.nanoTime();
        String solution4 = solution4(length, fares, credit);
        endTime = System.nanoTime();
        System.out.println("Solution with method 4 is: " + solution3 + " duration was : " + (endTime - startTime));
    }

    private static String solution(float length, float[] fares, float credit) {
        //This is the most efficient and the fastest
        for (int i = rides.length - 1; i >= 0; i--) {
            if( fares[i] * length <= credit )
                return rides[i];
        }

        return "";
    }

    private static String solution2(float length, float[] fares, float credit) {
        int index =
                IntStream
                        .range(0, rides.length)
                        .map(i -> rides.length - i - 1)
                        .filter( i -> fares[i] * length <= credit)
                        .findFirst()
                        .orElse(-1);
        if(index < 0)
            return "";
        else return rides[index];
    }

    private static String solution3(float length, float[] fares, float credit) {
        int index =
                IntStream
                        .range(0, rides.length)
                        .flatMap(i -> {
                            int indexT = rides.length - i - 1;
                            if(fares[indexT] * length <= credit)
                                return IntStream.of(indexT);
                            else
                                return IntStream.empty();
                        })
                        .findFirst()
                        .orElse(-1);
        if(index < 0)
            return "";
        else return rides[index];
    }

    private static String solution4(float length, float[] fares, float credit) {
        AtomicInteger index = new AtomicInteger(-1);

        boolean found = IntStream.range(0, rides.length)
                .map(i -> rides.length - i - 1)
                .filter( i -> fares[i] * length <= credit)
                .peek(index::set)
                .findAny()
                .isPresent();

        if (found) {
            return rides[index.get()];
        } else {
            return "";
        }
    }
}
