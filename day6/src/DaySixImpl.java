import java.util.Arrays;
import java.util.stream.IntStream;

public class DaySixImpl {

    public static int countCharactersUntilNonRepeatingForRange(String s, int expectedRange) {
        String checkS = s.replaceAll("\n", "");
        return IntStream.range(0, checkS.length()).filter(currentIndex -> charactersInSubString(checkS, currentIndex, expectedRange).equals(expectedRange)).findFirst().orElse(-1337 - expectedRange) + expectedRange;
    }

    private static Integer charactersInSubString(String s, int currentIndex, int expectedRange) {
        return Arrays.stream(getCurrentSubString(s, currentIndex, expectedRange).split("")).distinct().toList().size();
    }

    private static String getCurrentSubString(String s, int currentIndex, int expectedRange) {
        return s.substring(currentIndex, Math.min(currentIndex + expectedRange, s.length()));
    }
}
