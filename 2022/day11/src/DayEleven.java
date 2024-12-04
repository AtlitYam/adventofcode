import Utils.Monkey;
import fileutils.FileLoader;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class DayEleven {
    public static void main(String[] args) {
        Instant startTime = Instant.now();
        String filePath = "resources/DayElevenExample.txt";
        List<Monkey> file = FileLoader.loadFileAsListOfMonkeys(filePath);

        // For challenge one we have to find the two most active monkeys after 20 rounds
        System.out.printf("The result of the activity of the most active two monkeys is %s%n", DayElevenImpl.getActivityForTwoMostActive(file, 20, 3L));

        // For challenge two we have to find the activity of the two most active monkeys after 10.000 rounds, while no lowering our worry levels
        // This code fails because it cannot handle the numbers as they become too large to be handled normally by java variables and require higher math to track
        System.out.printf("The result of the activity of the most active two monkeys is %s%n", DayElevenImpl.getActivityForTwoMostActive(file, 10_000, 1L));
        System.out.printf("The expected challenge result is %s. The expected example result is %s.%n", 14314925001L, 2713310158L);

        System.out.printf("(Completed in %sms)%n", Duration.between(startTime, Instant.now()).toMillis());
    }
}
