import Utils.Monkey;

import java.util.List;

public class DayElevenImpl {

    public static Long getActivityForTwoMostActive(List<Monkey> listMonkey, Integer rounds, boolean doBoredom) {
        for (int i = 1; i <= rounds; i++) {
            for (Monkey monkey : listMonkey) {
                List<Long> inventoryBefore = monkey.getInventory();
                for (Long item : monkey.getInventory()) {
                    Long worryLevel = doInspection(item, monkey);
                    monkey.setInspections(monkey.getInspections() + 1);
                    if (doBoredom) {
                        worryLevel = doMonkeyBoredom(worryLevel);
                    }
                    if (doTest(worryLevel, monkey)) {
                        addItemToReceivingMonkey(worryLevel, Monkey.getMonkeyByName(monkey.getTestTrue(), listMonkey));
                    } else {
                        addItemToReceivingMonkey(worryLevel, Monkey.getMonkeyByName(monkey.getTestFalse(), listMonkey));
                    }
                }
                monkey.getInventory().removeAll(inventoryBefore);
            }
        }
        int[] totalInspections = listMonkey.stream().map(Monkey::getInspections).mapToInt(Integer::intValue).sorted().toArray();
        return ((long) totalInspections[totalInspections.length - 2] * totalInspections[totalInspections.length - 1]);
    }

    private static Long doInspection(Long worryLevel, Monkey monkey) {
        String[] splitOperation = monkey.getOperation().split(" ");
        if (splitOperation[1].equals("old")) splitOperation[1] = String.valueOf(worryLevel);
        return switch (splitOperation[0]) {
            case "*" -> worryLevel * Long.parseLong(splitOperation[1]);
            case "+" -> worryLevel + Long.parseLong(splitOperation[1]);
            default -> worryLevel;
        };
    }

    private static boolean doTest(Long worryLevel, Monkey monkey) {
        return worryLevel % monkey.getTest() == 0;
    }

    private static Long doMonkeyBoredom(Long worryLevel) {
        return worryLevel / 3;
    }

    private static void addItemToReceivingMonkey(Long worryLevel, Monkey receivingMonkey) {
        receivingMonkey.getInventory().add(worryLevel);
    }
}
