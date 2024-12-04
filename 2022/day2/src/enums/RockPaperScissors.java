package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static enums.Result.DRAW;
import static enums.Result.WIN;

@AllArgsConstructor
@Getter
public enum RockPaperScissors {
    ROCK("Rock", "A", "X", 1),
    PAPER("Paper", "B", "Y", 2),
    SCISSORS("Scissors", "C", "Z", 3);

    private final String name;
    private final String codeOne;
    private final String codeTwo;
    private final Integer points;

    public static RockPaperScissors getShapeFromCode(String code) {
        return Stream.of(RockPaperScissors.values())
                .filter(shape -> shape.getCodeOne().equals(code) ||
                        shape.getCodeTwo().equals(code))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public static RockPaperScissors getShapeWinsAgainst(RockPaperScissors rockPaperScissors) {
        return switch (rockPaperScissors) {
            case ROCK -> SCISSORS;
            case PAPER -> ROCK;
            case SCISSORS -> PAPER;
        };
    }

    public static RockPaperScissors getShapeThatProducesExpectedResult(RockPaperScissors shape, Result expectedResult) {
        return switch (shape) {
            case ROCK -> expectedResult.equals(DRAW) ? ROCK : expectedResult.equals(WIN) ? PAPER : SCISSORS;
            case PAPER -> expectedResult.equals(DRAW) ? PAPER : expectedResult.equals(WIN) ? SCISSORS : ROCK;
            case SCISSORS -> expectedResult.equals(DRAW) ? SCISSORS : expectedResult.equals(WIN) ? ROCK : PAPER;
        };
    }
}
