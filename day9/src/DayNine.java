import java.time.Duration;
import java.time.Instant;

public class DayNine {
    public static void main(String[] args) {
        Instant startTime = Instant.now();
        String filePath = "resources/DayNineExample.txt";


        System.out.printf("(Completed in %sms)%n", Duration.between(startTime, Instant.now()).toMillis());
    }
}
