package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import static utils.Commands.CD_DIR;

public class CommandExecutor {
    List<String> currentPath = new ArrayList<>();
    List<Folders> outputFolders = new ArrayList<>();
    List<Files> outputFiles = new ArrayList<>();

    // Helper functions
    private static String getCurrentFolderOrFile(List<String> currentPath) {
        return currentPath.get(currentPath.size() - 1);
    }

    private static String getCurrentParentFolder(List<String> currentPath) {
        return currentPath.get(currentPath.size() - 2);
    }

    private static void addStringToParentContentList(String s, Folders parentFolder) {
        parentFolder.getFolderContentList().add(s);
    }

    private static Folders getParentFolder(List<Folders> folders, List<String> currentPath) {
        return FilesAndFoldersHelper.getFolderByNameAndParent(folders, getCurrentFolderOrFile(currentPath), getCurrentParentFolder(currentPath));
    }

    private static String getUniqueID() {
        return RandomGenerator.getDefault().nextInt(1, 99) + "_";
    }

    // Main function
    public List<Object> executeCommandsInFile(List<String> file) {
        for (String line : file) {
            Commands currentCommand = Commands.getMatchingCommand(line);
            switch (currentCommand) {
                case FILE:
                    executeFileCommand(line);
                    continue;
                case CD_DIR:
                    executeCdDirCommand(line);
                    continue;
                case CD_DOTS:
                    executeCdDotsCommand();
                    continue;
                case CD_HOME:
                    executeCdHomeCommand();
                case LS:
                case DIR:
                    // Ignored
            }
        }
        return List.of(outputFolders, outputFiles);
    }

    // Command functions
    private void executeFileCommand(String line) {
        String[] splitLine = line.split(" ");
        String newFileName = "file_" + getUniqueID() + splitLine[1];

        outputFiles.add(new Files(getCurrentFolderOrFile(currentPath), newFileName, Integer.valueOf(splitLine[0])));

        if (!currentPath.get(currentPath.size() - 1).equals("root")) {
            addStringToParentContentList(newFileName, getParentFolder(outputFolders, currentPath));
        }
    }

    private void executeCdDirCommand(String line) {

        String newFolderName = "dir_" + getUniqueID() + line.replaceAll(CD_DIR.getReplacer(), "");

        if (!currentPath.get(currentPath.size() - 1).equals("root")) {
            addStringToParentContentList(newFolderName, getParentFolder(outputFolders, currentPath));
        }

        currentPath.add(newFolderName);
        outputFolders.add(new Folders(getCurrentParentFolder(currentPath), newFolderName, new ArrayList<>()));
    }

    private void executeCdDotsCommand() {
        currentPath.remove(currentPath.size() - 1);
    }

    private void executeCdHomeCommand() {
        currentPath.add("root");
        currentPath.add("home");
        outputFolders.add(new Folders("root", "home", new ArrayList<>()));
    }
}
