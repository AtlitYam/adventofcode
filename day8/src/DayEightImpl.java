import Utils.Trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static Utils.TreesHelper.getHighestX;
import static Utils.TreesHelper.getHighestY;
import static Utils.TreesHelper.getLowestX;
import static Utils.TreesHelper.getLowestY;

public class DayEightImpl {
    public Integer getUniqueTreesVisibleFromOutsideForest(List<Trees> forest) {
        Integer totalVisibleUniqueTrees = 0;
        Integer highestX = getHighestX(forest);
        Integer lowestX = getLowestX(forest);
        Integer highestY = getHighestY(forest);
        Integer lowestY = getLowestY(forest);

        // Check all trees for left to right X
        totalVisibleUniqueTrees += countTreesVertical(forest, lowestX, highestX, false);
        totalVisibleUniqueTrees += countTreesVertical(forest, lowestX, highestX, true);
        totalVisibleUniqueTrees += countTreesHorizontal(forest, lowestY, highestY, false);
        totalVisibleUniqueTrees += countTreesHorizontal(forest, lowestY, highestY, true);

        return totalVisibleUniqueTrees;
    }

    public Integer getHighestScenicValue(List<Trees> forest) {
        List<Integer> scenicValues = new ArrayList<>();
        for (Trees tree : forest) {

            scenicValues.add(
                    getTreesSeenHorizontal(forest, tree, getLowestX(forest), getHighestX(forest), false) *
                            getTreesSeenHorizontal(forest, tree, getLowestX(forest), getHighestX(forest), true) *
                            getTreesSeenVertical(forest, tree, getLowestY(forest), getHighestY(forest), false) *
                            getTreesSeenVertical(forest, tree, getLowestY(forest), getHighestY(forest), true)
            );
        }
        return scenicValues.stream().max(Comparator.naturalOrder()).orElse(0);
    }

    public Integer getTreesSeenHorizontal(List<Trees> forest, Trees targetTree, Integer startRange, Integer endRange, boolean reversed) {
        int treesSeen = 0;
        if (!reversed) {
            for (int i = targetTree.getX() + 1; i < endRange + 1; i++) {
                int finalI = i;
                Trees currentTree = forest.stream().filter(tree -> tree.getX().equals(finalI) & tree.getY().equals(targetTree.getY())).findFirst().orElseThrow();
                if (currentTree.getTreeHeight() >= targetTree.getTreeHeight()) {
                    treesSeen++;
                    break;
                } else {
                    treesSeen++;
                }
            }
        } else {
            for (int i = targetTree.getX() - 1; i > startRange - 1; i--) {
                int finalI = i;
                Trees currentTree = forest.stream().filter(tree -> tree.getX().equals(finalI) & tree.getY().equals(targetTree.getY())).findFirst().orElseThrow();
                if (currentTree.getTreeHeight() >= targetTree.getTreeHeight()) {
                    treesSeen++;
                    break;
                } else {
                    treesSeen++;
                }
            }
        }
        return treesSeen;
    }

    public Integer getTreesSeenVertical(List<Trees> forest, Trees targetTree, Integer startRange, Integer endRange, boolean reversed) {
        int treesSeen = 0;
        if (!reversed) {
            for (int i = targetTree.getY() + 1; i < endRange + 1; i++) {
                int finalI = i;
                Trees currentTree = forest.stream().filter(tree -> tree.getY().equals(finalI) & tree.getX().equals(targetTree.getX())).findFirst().orElseThrow();
                if (currentTree.getTreeHeight() >= targetTree.getTreeHeight()) {
                    treesSeen++;
                    break;
                } else {
                    treesSeen++;
                }
            }
        } else {
            for (int i = targetTree.getY() - 1; i > startRange - 1; i--) {
                int finalI = i;
                Trees currentTree = forest.stream().filter(tree -> tree.getY().equals(finalI) & tree.getX().equals(targetTree.getX())).findFirst().orElseThrow();
                if (currentTree.getTreeHeight() >= targetTree.getTreeHeight()) {
                    treesSeen++;
                    break;
                } else {
                    treesSeen++;
                }
            }
        }
        return treesSeen;
    }

    public Integer countTreesVertical(List<Trees> forest, Integer startRange, Integer endRange, boolean reversed) {
        return IntStream.range(startRange, endRange + 1).map(row -> {
            List<Trees> currentRowTrees = new ArrayList<>(getTreesForX(forest, startRange, endRange).stream().filter(tree -> tree.getX().equals(row)).toList());
            if (!reversed) {
                currentRowTrees.sort(Comparator.comparing(Trees::getY));
            } else {
                currentRowTrees.sort(Comparator.comparing(Trees::getY).reversed());
            }
            return countCurrentRowTrees(currentRowTrees);
        }).sum();
    }

    public Integer countTreesHorizontal(List<Trees> forest, Integer startRange, Integer endRange, boolean reversed) {
        return IntStream.range(startRange, endRange + 1).map(row -> {
            List<Trees> currentRowTrees = new ArrayList<>(getTreesForY(forest, startRange, endRange).stream().filter(tree -> tree.getY().equals(row)).toList());
            if (!reversed) {
                currentRowTrees.sort(Comparator.comparing(Trees::getX));
            } else {
                currentRowTrees.sort(Comparator.comparing(Trees::getX).reversed());
            }
            return countCurrentRowTrees(currentRowTrees);
        }).sum();
    }

    public Integer countCurrentRowTrees(List<Trees> trees) {
        Integer highestTree = -1;
        Integer totalVisibleUniqueTreesInCurrentRow = 0;
        for (Trees tree : trees) {
            if (tree.getTreeHeight() > highestTree) {
                highestTree = tree.getTreeHeight();
                if (!tree.isCounted()) {
                    totalVisibleUniqueTreesInCurrentRow++;
                    tree.setCounted(true);
                }
            }
        }
        return totalVisibleUniqueTreesInCurrentRow;
    }

    public List<Trees> getTreesForX(List<Trees> forest, Integer startRange, Integer endRange) {
        return new ArrayList<>(IntStream.range(startRange, endRange + 1)
                .mapToObj(row -> forest.stream()
                        .filter(tree -> tree.getX().equals(row))
                        .toList()).flatMap(List::stream).toList());
    }

    public List<Trees> getTreesForY(List<Trees> forest, Integer startRange, Integer endRange) {
        return new ArrayList<>(IntStream.range(startRange, endRange + 1)
                .mapToObj(row -> forest.stream()
                        .filter(tree -> tree.getY().equals(row))
                        .toList()).flatMap(List::stream).toList());
    }
}
