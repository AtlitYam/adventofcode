import java.time.Duration;
import java.time.Instant;

public class DayTen {
    public static void main(String[] args) {
        Instant startTime = Instant.now();
        String filePath = "resources/DayTenExample.txt";


        System.out.printf("(Completed in %sms)%n", Duration.between(startTime, Instant.now()).toMillis());
    }
}
