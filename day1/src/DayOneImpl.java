import fileutils.FileLoader;
import listutils.ListMapper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DayOneImpl {
    FileLoader fileLoader = new FileLoader();
    ListMapper listMapper = new ListMapper();

    public Integer getMostCalories(String filePath) {
        return getListOfTotals(filePath).stream().max(Comparator.naturalOrder()).orElse(-1);
    }

    public Integer getTotalTopThreeCalories(String filePath) {
        return calculateTotal(getListOfTotals(filePath).stream().sorted(Comparator.reverseOrder()).limit(3).toList());
    }

    private List<Integer> getListOfTotals(String filePath) {
        List<String> fileArray = fileLoader.loadFileAsList(filePath);
        List<Integer> totals = new ArrayList<>();
        listMapper.mapList(fileArray).forEach(elf -> totals.add(calculateTotal(elf)));

        return totals;
    }

    private Integer calculateTotal(List<Integer> input) {
        return input.stream().mapToInt(Integer::intValue).sum();
    }
}