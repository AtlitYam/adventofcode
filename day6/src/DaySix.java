import java.time.Duration;
import java.time.Instant;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static fileutils.FileLoader.loadFileAsString;

public class DaySix {
    public static void main(String[] args) {
        Instant startTime = Instant.now();
        String filePath = "resources/DaySixExample.txt";
        Instant startTimeGeneratingString = Instant.now();
        String randomString = IntStream.range(0, RandomGenerator.getDefault().nextInt(0, 2147000000)).mapToObj(i -> String.valueOf((char) RandomGenerator.getDefault().nextInt(33, 126))).collect(Collectors.joining());
        System.out.printf("(Generating random completed in %sms)%n", Duration.between(startTimeGeneratingString, Instant.now()).toMillis());
        Instant startTimeChallenge = Instant.now();
        System.out.printf("Starting the Challenges%n");
        // For the first challenge we have to find the amount of characters until a block of 4 unique characters in a given string
        System.out.printf("The amount of characters before a block of four non-repeating characters appeared is: %s%n", DaySixImpl.countCharactersUntilNonRepeatingForRange(loadFileAsString(filePath), 4));

        // For the second challenge we have to find the amount of characters until a block of 14 unique characters in a given string
        System.out.printf("The amount of characters before a block of four non-repeating characters appeared is: %s%n", DaySixImpl.countCharactersUntilNonRepeatingForRange(loadFileAsString(filePath), 14));

        System.out.printf("(Challenge completed in %sms)%n", Duration.between(startTimeChallenge, Instant.now()).toMillis());
        Instant startTimeRandom = Instant.now();

        // For my own fun I decided to add in randomized strings and work those out
        System.out.printf("Starting the random bit%n");
        System.out.printf("The amount of characters before a block of four non-repeating characters appeared in random string is: %s%n", DaySixImpl.countCharactersUntilNonRepeatingForRange(randomString, 4));
        System.out.printf("The amount of characters before a block of four non-repeating characters appeared in random string is: %s%n", DaySixImpl.countCharactersUntilNonRepeatingForRange(randomString, 14));
        int expectedRange = 69;
        System.out.printf("The amount of characters before a block of %s non-repeating characters appeared in random string is: %s%n", expectedRange, DaySixImpl.countCharactersUntilNonRepeatingForRange(randomString, expectedRange));

        System.out.printf("(Random completed in %sms)%n", Duration.between(startTimeRandom, Instant.now()).toMillis());

        System.out.printf("(Fully completed in %sms)%n", Duration.between(startTime, Instant.now()).toMillis());
    }
}
