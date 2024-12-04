package Utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Getter
public class Monkey {
    private final String name;
    private final String operation;
    private final Long test;
    private final String testTrue;
    private final String testFalse;
    private List<Long> inventory;
    @Setter
    private Long inspections;

    public static Monkey getMonkeyByName(String name, List<Monkey> monkeyList) {
        return monkeyList.stream()
                .filter(monkey -> monkey.getName().toLowerCase().equals(name))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
