package others;

import java.util.Random;

public class ReverseString {
    public static void main(String[] args) {

        String phrase = generateLongPhrase(1_000_000);

        long startTime = System.nanoTime();
        String solution = solution(phrase);
        long endTime = System.nanoTime();
        System.out.println("Solution with method 1 is: [] duration was : " + (endTime - startTime));

        startTime = System.nanoTime();
        String solution2 = solution2(phrase);
        endTime = System.nanoTime();
        System.out.println("Solution with method 1 is: [] duration was : " + (endTime - startTime));
    }

    private static String solution(String phrase) {
        //This is preferred, it consumes less resources
        StringBuilder result = new StringBuilder();
        for (int i = phrase.length() - 1; i >= 0; i--) {
            result.append(phrase.charAt(i));
        }
        return result.toString();
    }

    private static String solution2(String phrase) {
        String result = "";
        for (int i = phrase.length() - 1; i >= 0; i--) {
            result += phrase.charAt(i);
        }
        return result;
    }

    private static String generateLongPhrase(int length) {
        Random random = new Random();
        StringBuilder word = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            word.append((char)('a' + random.nextInt(26)));
        }

        return word.toString();
    }
}
