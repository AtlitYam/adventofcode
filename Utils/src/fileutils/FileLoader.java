package fileutils;

import Utils.Boxes;
import Utils.CommandExecutor;
import Utils.Moves;
import Utils.Trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileLoader {
    public static String loadFileAsString(String pathname) {
        StringBuilder output = new StringBuilder();
        try {
            File file = new File(pathname);
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                output.append(fileReader.nextLine()).append("\n");
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return output.toString();
    }

    public static List<String> loadFileAsList(String filePath) {
        List<String> output = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                output.add(fileReader.nextLine());
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return output;
    }

    public static List<List<String>> loadFileAsListOfLists(String filePath) {
        List<List<String>> output = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                output.add(List.of(fileReader.nextLine().split(",")));
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return output;
    }

    public static List<Boxes> loadBoxesFromFile(String filePath) {
        List<String> lines = new ArrayList<>();
        List<List<String>> boxLines = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                lines.add(fileReader.nextLine()
                        .replaceAll("[\s]{4,4}", "_")
                        .replaceAll("[\\[\\]]", ".")
                        .replaceAll("[\s]{1,}", ".")
                        .replaceAll("[.]{1,}", ""));
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (String line : lines) {
            if (line.contains("1")) {
                continue;
            }
            boxLines.add(List.of(line.split("")));
        }

        Collections.reverse(boxLines);
        return boxLines.stream().map(line -> {
            List<Boxes> list = new ArrayList<>();
            for (int i = 0; i < line.size(); i++) {
                Boxes boxes = new Boxes(line.get(i), i + 1, boxLines.indexOf(line) + 1);
                list.add(boxes);
            }
            return list.stream().filter(box -> !box.getName().equals("_")).filter(box -> !box.getName().equals(" ")).toList();
        }).flatMap(List::stream).toList();
    }

    public static List<Moves> loadMovesFromFile(String filePath) {
        List<String> lines = new ArrayList<>();
        List<Moves> output = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                lines.add(fileReader.nextLine());
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (String line : lines) {
            if (line.matches("move [0-9]{1,} from [0-9]{1,} to [0-9]{1,}")) {
                output.add(Moves.mapStringToMove(line));
            }
        }
        return output;
    }

    public static List<Object> loadFolderStructureFromFile(String filePath) {
        List<String> file = loadFileAsList(filePath);
        CommandExecutor commandExecutor = new CommandExecutor();
        return commandExecutor.executeCommandsInFile(file);
    }

    public static List<Trees> loadFileAsListOfTrees(String uwu) {
        List<String> lines = loadFileAsList(uwu);
        List<List<String>> treeLines = new ArrayList<>();

        for (String line : lines) {
            treeLines.add(List.of(line.split("")));
        }

        return treeLines.stream().map(line -> {
            List<Trees> list = new ArrayList<>();
            for (int i = 0; i < line.size(); i++) {
                Trees trees = new Trees(Integer.valueOf(line.get(i)), i + 1, treeLines.indexOf(line) + 1, false);
                list.add(trees);
            }
            return list.stream().toList();
        }).flatMap(List::stream).toList();
    }
}
