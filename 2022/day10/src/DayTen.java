import fileutils.FileLoader;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class DayTen {
    public static void main(String[] args) {
        Instant startTime = Instant.now();
        String filePath = "resources/DayTenChallenge.txt";
        List<String> file = FileLoader.loadFileAsList(filePath);

        // For the first challenge we need to get the sum of the 20th, 60th, 100th, 140th, 180th and 220th cycle multiplied by the X at the time
        System.out.printf("The total signal strength during the check cycles is %s%n", DayTenImpl.getTotalSignalStrength(file));

        // For the second challenge we need to draw out the CRT by measuring the sprite position and where the CRT is drawing
        String crtOutput = DayTenImpl.getCRTOutput(file);
        System.out.printf("%s%n", crtOutput.substring(0, 40));
        System.out.printf("%s%n", crtOutput.substring(40, 80));
        System.out.printf("%s%n", crtOutput.substring(80, 120));
        System.out.printf("%s%n", crtOutput.substring(120, 160));
        System.out.printf("%s%n", crtOutput.substring(160, 200));
        System.out.printf("%s%n", crtOutput.substring(200, 240));

        System.out.printf("(Completed in %sms)%n", Duration.between(startTime, Instant.now()).toMillis());
    }
}
