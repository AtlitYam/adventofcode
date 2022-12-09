package Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum Commands {
    CD_DIR("\\$ cd [a-z]{1,}", "\\$ cd "),
    CD_DOTS("\\$ cd \\.\\.", ""),
    CD_HOME("\\$ cd \\/", ""),
    LS("\\$ ls", ""),
    DIR("dir [a-z]{1,}", "dir "),
    FILE("[0-9]{1,} [a-z.]{1,}", "");

    private final String matcher;
    private final String replacer;

    public static Commands getMatchingCommand(String line) {
        try {
            return Stream.of(Commands.values())
                    .filter(command -> line.matches(command.getMatcher()))
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException e) {
            System.out.printf("An error occurred for the string: %s", line);
            throw new NoSuchElementException();
        }
    }
}
