package listutils;

import org.json.JSONArray;
import utils.NumberPairs;

import java.util.ArrayList;
import java.util.List;

public class ListMapper {
    public static List<List<Integer>> mapList(List<String> input) {
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

    public List<List<NumberPairs>> mapListToNumberPairs(List<List<String>> listOfListOfStrings) {
        return listOfListOfStrings.stream().map(listOfStrings -> listOfStrings.stream().map(this::mapStringToNumberPairs).toList()).toList();
    }

    private NumberPairs mapStringToNumberPairs(String numberPairAsList) {
        return new NumberPairs(numberPairAsList);
    }

    private static boolean isLastRowInInput(String row, List<String> input) {
        return input.indexOf(row) == input.size() - 1;
    }

    public static JSONArray listStringToObjectArray(String input) {
        return new JSONArray(input);
    }
}
