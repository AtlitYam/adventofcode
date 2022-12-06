import java.time.Duration;
import java.time.Instant;

public class DaySeven {
    public static void main(String[] args) {
        Instant startTime = Instant.now();
        String filePath = "resources/DaySevenExample.txt";


        System.out.printf("(Completed in %sms)%n", Duration.between(startTime, Instant.now()).toMillis());
    }
}
