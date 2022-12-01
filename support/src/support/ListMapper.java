package support;

import java.util.ArrayList;
import java.util.List;

public class ListMapper {
    public List<List<Integer>> mapList(List<String> input) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();

        // Creates grouped lists based on empty rows in the input
        for (String row : input) {
            if (isLastRowInInput(row, input)) {
                currentList.add(Integer.valueOf(row));
                output.add(currentList);
                break;
            }
            if (row.isBlank()) {
                output.add(currentList);
                currentList = new ArrayList<>();
                continue;
            }
            currentList.add(Integer.valueOf(row));
        }
        return output;
    }

    private boolean isLastRowInInput(String row, List<String> input) {
        return input.indexOf(row) == input.size() - 1;
    }
}
