import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static fileutils.FileLoader.loadFileAsList;

public class DayThreeImpl {
    private static List<List<String>> getCompartmentalizedBackpacksFromFile(String filePath) {
        List<String> file = loadFileAsList(filePath);
        return file.stream().map(row -> List.of(getFirstCompartment(row), getSecondCompartment(row))).toList();
    }

    private static String getDuplicateLetterFromBackpack(List<String> backpack) {
        String[] firstCompartment = backpack.get(0).split("");
        String secondCompartment = backpack.get(1);

        return Arrays.stream(firstCompartment).filter(secondCompartment::contains).findFirst().orElse("");
    }

    private static String getFirstCompartment(String backpack) {
        return backpack.substring(0, backpack.length() / 2);
    }

    private static String getSecondCompartment(String backpack) {
        return backpack.substring(backpack.length() / 2);
    }

    public Integer getSumOfPrioritiesForDuplicates(String filePath) {
        return getCompartmentalizedBackpacksFromFile(filePath).stream().mapToInt(this::getPriorityForDuplicateLetter).sum();
    }

    public Integer getSumOfPrioritiesForBadges(String filePath) {
        return getBadgesFromBackpacks(filePath).stream().mapToInt(this::getPriority).sum();
    }

    private List<String> getBadgesFromBackpacks(String filePath) {
        Collection<List<String>> backpacks = getBackpacksInGroupsOfThree(filePath);
        return backpacks.stream().map(backpack -> getBadgeForBackpack(backpack.get(0), backpack)).toList();
    }

    private String getBadgeForBackpack(String backpack, List<String> backpacks) {
        return Stream.of(backpack.split("")).filter(letter ->
                        backpacks.stream().filter(currentBackpack -> currentBackpack.contains(letter)).count() == 3)
                .findFirst().orElse("");
    }

    private Collection<List<String>> getBackpacksInGroupsOfThree(String filePath) {
        AtomicInteger counter = new AtomicInteger();
        List<String> backpacks = loadFileAsList(filePath);
        return backpacks.stream().collect(Collectors.groupingBy(gr -> counter.getAndIncrement() / 3)).values();
    }

    private Integer getPriorityForDuplicateLetter(List<String> backpack) {
        return getPriority(getDuplicateLetterFromBackpack(backpack));
    }

    public Integer getPriority(String letter) {
        List<String> letterList = List.of("", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
        return letterList.indexOf(letter);
    }
}
