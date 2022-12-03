package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum Result {
    WIN("win", 6, "Z"),
    DRAW("draw", 3, "Y"),
    LOSS("loss", 0, "X");

    private final String name;
    private final Integer points;

    private final String expectedResultCode;

    public static Result getExpectedResultFromCode(String code) {
        return Stream.of(Result.values())
                .filter(result -> result.getExpectedResultCode().equals(code))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
