import Utils.Moves;

import java.time.Duration;
import java.time.Instant;

public class DayFiveGenerateRandomMovesList {
    public static void main(String[] args) {
        Instant startTime = Instant.now();

        Moves.printRandomMoves(Moves.generateRandomMoves(10000, 150, 216));

        System.out.printf("(Completed in %sms)%n", Duration.between(startTime, Instant.now()).toMillis());
    }
}
