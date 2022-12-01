import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static fileutils.FileLoader.loadFileAsList;
import static listutils.ListMapper.mapList;

public class DayOneImpl {

    public static Integer getMostCalories(String filePath) {
        return getListOfTotals(filePath).stream().max(Comparator.naturalOrder()).orElse(-1);
    }

    public static Integer getTotalTopThreeCalories(String filePath) {
        return calculateTotal(getListOfTotals(filePath).stream().sorted(Comparator.reverseOrder()).limit(3).toList());
    }

    private static List<Integer> getListOfTotals(String filePath) {
        List<String> fileArray = loadFileAsList(filePath);
        List<Integer> totals = new ArrayList<>();
        mapList(fileArray).forEach(elf -> totals.add(calculateTotal(elf)));

        return totals;
    }

    private static Integer calculateTotal(List<Integer> input) {
        return input.stream().mapToInt(Integer::intValue).sum();
    }
}