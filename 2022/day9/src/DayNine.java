import fileutils.FileLoader;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class DayNine {
    public static void main(String[] args) {
        Instant startTime = Instant.now();
        String filePath = "resources/DayNineChallenge.txt";
        List<String> file = FileLoader.loadFileAsList(filePath);

        // The first challenge is to figure out how many unique positions the tail has visited.
        System.out.printf("The amount of unique positions the tail visited is: %s%n", DayNineImpl.getTailUniquePositions(file, false));

        // The first challenge is to figure out how many unique positions the last tail has visited.
        System.out.printf("The amount of unique positions the ninth tail visited is: %s%n", DayNineImpl.getNinthTailUniquePositions(file, false));

        System.out.printf("(Completed in %sms)%n", Duration.between(startTime, Instant.now()).toMillis());
    }
}
