package utils;

import java.util.List;

public class FilesAndFoldersHelper {

    public static Integer getSizeOfFolder(List<Folders> folders, List<Files> files, Folders folder) {
        Integer total = getSizeOfFilesInFolder(files, folder);
        List<Folders> subFolders = getSubFoldersForFolder(folders, folder);
        for (Folders subFolder : subFolders) {
            total += getSizeOfFolder(folders, files, subFolder);
        }
        return total;
    }

    public static Integer getSizeOfFilesInFolder(List<Files> files, Folders folder) {
        return getFilesForFolder(files, folder).stream().map(Files::getFileSize).mapToInt(Integer::intValue).sum();
    }

    public static Folders getFolderByNameAndParent(List<Folders> folders, String folderName, String parentName) {
        return folders.stream()
                .filter(folder -> folder.getFolderName().equals(folderName) & folder.getParentFolder().equals(parentName))
                .findFirst().orElseThrow();
    }

    public static List<Folders> getSubFoldersForFolder(List<Folders> folders, Folders folder) {
        return folders.stream().filter(subFolder -> subFolder.getParentFolder().equals(folder.getFolderName())
                & folder.getFolderContentList().contains(subFolder.getFolderName())).toList();
    }

    public static List<Files> getFilesForFolder(List<Files> files, Folders folder) {
        return files.stream().filter(file -> file.getParentFolder().equals(folder.getFolderName()) &
                folder.getFolderContentList().contains(file.getFileName())).toList();
    }
}
