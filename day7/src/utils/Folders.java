package utils;

import lombok.Getter;

import java.util.List;

@Getter
public class Folders {
    private final String parentFolder;
    private final String folderName;
    private final List<String> folderContentList;

    public Folders(String parentFolder, String folderName, List<String> folderContentList) {
        this.parentFolder = parentFolder;
        this.folderName = folderName;
        this.folderContentList = folderContentList;
    }
}
