import fileutils.FileLoader;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class DayTwelve {
    public static void main(String[] args) {
        Instant startTime = Instant.now();
        String filePath = "resources/DayTwelveExample.txt";
        List<String> file = FileLoader.loadFileAsList(filePath);


        System.out.printf("(Completed in %sms)%n", Duration.between(startTime, Instant.now()).toMillis());
    }
}
